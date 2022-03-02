package dev.pagefault.eve.dirtd.task;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.db.OrderSetTable;
import dev.pagefault.eve.dbtools.db.StructAuthTable;
import dev.pagefault.eve.dbtools.model.MarketOrder;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import dev.pagefault.eve.dirtd.esi.MarketApiWrapper;
import dev.pagefault.eve.dirtd.esi.auth.OAuthUtil;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.models.GetMarketsRegionIdOrders200Ok;
import net.evetech.esi.models.GetMarketsStructuresStructureId200Ok;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Task to get bulk market orders by region, public and structure
 * 
 * @author austin
 */
public class MarketRegionOrdersTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();

	private static final int FORBIDDEN_RETRIES = 5;
	private static final int NUM_ET_THREADS = 4;
	private static final int BATCH_SIZE = 1000;
	private static final String INSERT_SQL = "INSERT INTO marketorder ("
			+ "`setId`,`issued`,`range`,`isBuyOrder`,`duration`,`orderId`,`volumeRemain`,"
			+ "`minVolume`,`typeId`,`volumeTotal`,`locationId`,`price`"
			+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

	private final int region;
	private int setId;

	private long eTime;
	private long tTime;
	private long lTime;

	public MarketRegionOrdersTask(int region) {
		this.region = region;
	}

	@Override
	public String getTaskName() {
		return "market-region-orders-" + region;
	}

	@Override
	protected void runTask() {
		// generate a new set
		try {
			setId = OrderSetTable.buildNewSet(getDb(), region);
		} catch (SQLException e) {
			log.fatal("Failed to create new orderset", e);
			return;
		}

		// get publicly available orders in this region
		doPublicOrders();
		// get orders in structures in this region
		doStructOrders();

		log.info("Time spent e/t/l : " + eTime + "/" + tTime + "/" + lTime);

		// update this as the latest set
		try {
			OrderSetTable.updateLatest(getDb(), region, setId);
		} catch (SQLException e) {
			log.error("Failed to update pointer to latest set for region " + region, e);
		}
	}

	private void doPublicOrders() {
		ConcurrentLinkedQueue<MarketOrder> queue = new ConcurrentLinkedQueue<>();

		// get the first page to get the total number of pages from the headers
		MarketApiWrapper mapiw = new MarketApiWrapper(getDb());
		List<GetMarketsRegionIdOrders200Ok> orders;
		int numPages;
		try {
			ApiResponse<List<GetMarketsRegionIdOrders200Ok>> resp = mapiw.getMarketsRegionIdOrders(region, 1);
			orders = resp.getData();
			numPages = EsiUtils.extractNumPages(resp);
			log.debug("detected " + numPages + " pages in header");
		} catch (ApiException e) {
			log.error("Failed to retrieve page 1 of orders for region " + region + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		log.debug("Retrieved " + orders.size() + " orders for region " + region + " page 1");

		for (GetMarketsRegionIdOrders200Ok o : orders) {
			MarketOrder m = TypeUtil.convert(o);
			m.setSetId(setId);
			queue.add(m);
		}

		// spawn L thread
		Thread l = new Thread(new LWorkerThread(getDb(), queue));
		l.setName("mrot-load-" + region);
		l.start();

		// spawn ET threads
		ArrayList<Thread> threads = new ArrayList<>(NUM_ET_THREADS);
		int range = numPages / NUM_ET_THREADS;
		int p = 2;
		int i = 1;
		while(p < numPages) {
			int s = p;
			int e = Math.min(s + range, numPages);
			Thread t = new Thread(new ETWorkerThread(setId, region, s, e, queue));
			t.setName("mrot-extr-" + region + "-" + i);
			threads.add(t);
			t.start();
			p = e;
			i++;
		}

		// wait for ET threads
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException ignored) {
			}
		});
		// notify L thread one last time and wait for it
		l.interrupt();
		try {
			l.join();
		} catch (InterruptedException ignored) {
		}
	}

	private void doStructOrders() {
		// get struct ids in this region that have at least 1 associated auth key
		List<Long> structs;
		try {
			structs = StructAuthTable.getStructIdByRegion(getDb(), region);
		} catch (SQLException e) {
			log.fatal("Failed to search for authed structures for region " + region + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		if (structs.isEmpty()) {
			log.debug("No authed structures for region " + region);
			return;
		}

		for (Long structId : structs) {
			doStructOrder(structId);
		}
	}

	private void doStructOrder(long structId) {
		// get auth key ids associated with this struct
		List<Integer> keys;
		try {
			keys = StructAuthTable.getAuthKeyByStruct(getDb(), structId);
		} catch (SQLException e) {
			log.error("Failed to get auth key id for structure " + structId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		if (keys.isEmpty()) {
			log.error("No auth key id for structure " + structId);
			return;
		}
		int keyId = keys.get(0);

		// get the auth token
		OAuthUser auth;
		try {
			auth = ApiAuthTable.getUserByKeyId(getDb(), keyId);
		} catch (SQLException e) {
			log.error("Failed to get auth details for key " + keyId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		if (auth == null) {
			log.error("No auth details found for key " + keyId);
			return;
		}

		// iterate through the pages
		MarketApiWrapper mapiw = new MarketApiWrapper(getDb());
		int page = 0;
		int totalOrders = 0;
		int numPages;
		do {
			long eStart = System.currentTimeMillis();
			page++;
			List<GetMarketsStructuresStructureId200Ok> orders;
			try {
				ApiResponse<List<GetMarketsStructuresStructureId200Ok>> resp = mapiw.getMarketsStructureIdOrders(structId, page, OAuthUtil.getAuthToken(getDb(), auth));
				orders = resp.getData();
				numPages = EsiUtils.extractNumPages(resp);
				Utils.putKV(getDb(), "forbidden-" + structId, "0"); // reset forbidden retry counter
			} catch (ApiException e) {
				if (e.getCode() == 304) {
					break;
				} else if (e.getCode() == 403) {
					forbidden(structId, keyId);
					break;
				} else {
					log.error("Failed to retrieve page " + page + " of orders for structure " + structId + ": " + e.getLocalizedMessage());
					log.debug(e);
					break;
				}
			}
			eTime += System.currentTimeMillis() - eStart;
			log.debug("Retrieved " + orders.size() + " orders for structure " + structId + " page " + page);
			if (orders.isEmpty()) {
				break;
			}

			long tStart = System.currentTimeMillis();
			totalOrders += orders.size();
			List<MarketOrder> l = new ArrayList<>(orders.size());
			for (var o : orders) {
				MarketOrder m = TypeUtil.convert(o);
				m.setSetId(setId);
				l.add(m);
			}
			tTime += System.currentTimeMillis() - tStart;

			long lStart = System.currentTimeMillis();
			try (PreparedStatement stmt = getDb().prepareStatement(INSERT_SQL)) {
				for (int i=0; i<l.size(); i++) {
					fill(stmt, l.get(i));
					stmt.addBatch();
					if ((i + 1) % BATCH_SIZE == 0 || i == l.size() - 1) {
						getDb().setAutoCommit(false);
						stmt.executeBatch();
						getDb().commit();
						getDb().setAutoCommit(true);
					}
				}
				log.debug("Inserted " + l.size() + " orders for structure " + structId + " page " + page);
			} catch (SQLException e) {
				log.error("Unexpected failure while processing page " + page + " for structure " + structId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
			lTime += System.currentTimeMillis() - lStart;
		} while (page < numPages);

		log.debug("Inserted " + totalOrders + " total orders for structure " + structId);
	}

	private void forbidden(long structId, int keyId) {
		// TODO: try other keys
		String scount = Utils.getKV(getDb(), "forbidden-" + structId);
		int count = 0;
		if (scount != null) {
			try {
				count = Integer.parseInt(scount);
			} catch(NumberFormatException e) {
				log.warn("Failed to parse value for kv key: forbidden-" + structId);
			}
		}
		count++; // increment for this attempt

		log.warn("Access forbidden to structure " + structId + " (attempt " + count + ")");

		if (count > FORBIDDEN_RETRIES) {
			// reached limit, remove key
			try {
				log.warn("Reached retry limit for forbidden, removing structAuth for struct " + structId + " and key " + keyId);
				StructAuthTable.deleteStructAuth(getDb(), structId, keyId);
			} catch (SQLException e) {
				log.error("Failed to remove structAuth for structure " + structId + " with key " + keyId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
		}
		Utils.putKV(getDb(), "forbidden-" + structId, "" + count);
	}

	private static void fill(PreparedStatement stmt, MarketOrder o) throws SQLException {
		stmt.setInt(1, o.getSetId());
		stmt.setTimestamp(2, o.getIssued());
		stmt.setInt(3, o.getRange());
		stmt.setBoolean(4, o.isBuyOrder());
		stmt.setShort(5, o.getDuration());
		stmt.setLong(6, o.getOrderId());
		stmt.setInt(7, o.getVolumeRemain());
		stmt.setInt(8, o.getMinVolume());
		stmt.setInt(9, o.getTypeId());
		stmt.setInt(10, o.getVolumeTotal());
		stmt.setLong(11, o.getLocationId());
		stmt.setDouble(12, o.getPrice());
	}

	private static class ETWorkerThread implements Runnable {
		private final int setId;
		private final int region;
		private final int startPage;
		private final int endPage;
		private final ConcurrentLinkedQueue<MarketOrder> orderQueue;

		public ETWorkerThread(int setId, int region, int startPage, int endPage, ConcurrentLinkedQueue<MarketOrder> orderQueue) {
			this.setId = setId;
			this.region = region;
			this.startPage = startPage;
			this.endPage = endPage;
			this.orderQueue = orderQueue;
		}

		@Override
		public void run() {
			long eTime = 0;
			long tTime = 0;

			// iterate through the pages
			// we can pass null db for this specific subtask only, since we ignore etags
			MarketApiWrapper mapiw = new MarketApiWrapper(null);
			for (int page=startPage; page<=endPage; page++) {
				long eStart = System.currentTimeMillis();
				List<GetMarketsRegionIdOrders200Ok> orders;
				try {
					orders = mapiw.getMarketsRegionIdOrders(region, page).getData();
				} catch (ApiException e) {
					log.error("Failed to retrieve page " + page + " of orders for region " + region + ": " + e.getLocalizedMessage());
					log.debug(e);
					continue;
				}
				eTime += System.currentTimeMillis() - eStart;
				log.debug("Retrieved " + orders.size() + " orders for region " + region + " page " + page);

				long tStart = System.currentTimeMillis();
				List<MarketOrder> l = new ArrayList<>(orders.size());
				for (GetMarketsRegionIdOrders200Ok o : orders) {
					MarketOrder m = TypeUtil.convert(o);
					m.setSetId(setId);
					l.add(m);
				}
				tTime += System.currentTimeMillis() - tStart;

				orderQueue.addAll(l);
				synchronized (orderQueue) {
					orderQueue.notify();
				}
			}

			log.info("Time spent e/t : " + eTime + "/" + tTime);
		}
	}

	private static class LWorkerThread implements Runnable {

		private final Connection db;
		private final ConcurrentLinkedQueue<MarketOrder> orderQueue;

		private long lTime;

		public LWorkerThread(Connection db, ConcurrentLinkedQueue<MarketOrder> orderQueue) {
			this.db = db;
			this.orderQueue = orderQueue;
		}

		@Override
		public void run() {

			boolean done = false;
			while (!done) {
				try {
					synchronized (orderQueue) {
						orderQueue.wait();
					}
				} catch (InterruptedException e) {
					// use this as a signal from the main thread that the ET threads are done
					// empty the queue one last time and then return
					done = true;
				}

				long lStart = System.currentTimeMillis();
				try (PreparedStatement stmt = db.prepareStatement(INSERT_SQL)) {
					int count = 0;
					while (true) {
						MarketOrder o = orderQueue.poll();
						if (o != null) {
							fill(stmt, o);
							stmt.addBatch();
							count++;
						}
						// execute at batch size or if we've exhausted the queue
						if (count % BATCH_SIZE == 0 || o == null) {
							db.setAutoCommit(false);
							stmt.executeBatch();
							db.commit();
							db.setAutoCommit(true);
							if (o == null) {
								// end of queue, go back to waiting
								break;
							}
						}
					}
					log.debug("Inserted " + count + " orders");
				} catch (SQLException e) {
					log.error("Unexpected failure while loading orders into db: " + e.getLocalizedMessage());
					log.debug(e);
				}
				lTime += System.currentTimeMillis() - lStart;
			}

			log.info("Time spent l : " + lTime);
		}
	}
}
