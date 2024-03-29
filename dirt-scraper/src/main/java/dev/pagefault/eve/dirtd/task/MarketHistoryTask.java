package dev.pagefault.eve.dirtd.task;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.InvTypeTable;
import dev.pagefault.eve.dbtools.db.MarketHistoryTable;
import dev.pagefault.eve.dbtools.db.MarketStatTable;
import dev.pagefault.eve.dbtools.model.MarketHistoryEntry;
import dev.pagefault.eve.dbtools.model.MarketStat;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.MarketApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetMarketsRegionIdHistory200Ok;

/**
 * Task to get market history for all items by region. Spawns 4 subtasks.
 * 
 * @author austin
 */
public class MarketHistoryTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();

	private final int region;

	public MarketHistoryTask(int region) {
		this.region = region;
	}

	@Override
	public String getTaskName() {
		return "market-history-" + region;
	}

	@Override
	public void runTask() {
		List<Integer> types;
		try {
			types = InvTypeTable.getMarketableTypeIds(getDb());
			log.debug("Found " + types.size() + " marketable types");
		} catch (SQLException e) {
			log.fatal("Failed to get list of marketable type ids from database: " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
//		int s = types.size();
//		List<Integer> a = types.subList(0, s / 4);
//		List<Integer> b = types.subList(s / 4, s / 2);
//		List<Integer> c = types.subList(s / 2, 3 * s / 4);
//		List<Integer> d = types.subList(3 * s / 4, s);
//		getExecutor().scheduleTask(new HistorySubTask(region, a, 1));
//		getExecutor().scheduleTask(new HistorySubTask(region, b, 2));
//		getExecutor().scheduleTask(new HistorySubTask(region, c, 3));
//		getExecutor().scheduleTask(new HistorySubTask(region, d, 4));
		getExecutor().scheduleTask(new HistorySubTask(region, types, 1));
	}

	private static class HistorySubTask extends DirtTask {

		private final int region;
		private final List<Integer> types;
		private final int subTaskId;

		public HistorySubTask(int region, List<Integer> types, int subTaskId) {
			this.region = region;
			this.types = types;
			this.subTaskId = subTaskId;
		}

		@Override
		public String getTaskName() {
			return "market-history-subtask-" + region + "-" + subTaskId;
		}

		@Override
		protected void runTask() {
			log.debug("Retrieving market history for " + types.size() + " types");
			try {
				getDb().setAutoCommit(false);
			} catch (SQLException e) {
				log.fatal("Failed to set autocommit=false");
				return;
			}
			for (Integer type : types) {
				List<MarketHistoryEntry> hs = getHistory(region, type);
				try {
					MarketHistoryTable.insertMany(getDb(), hs);
					getDb().commit();
					calcStat(hs, type);
					getDb().commit();
					log.debug("Inserted " + hs.size() + " history entries for region " + region + " type " + type);
				} catch (SQLException e) {
					log.error("Failed to insert history for type " + type + " for region " + region + ": " + e.getLocalizedMessage());
					log.debug(e);
					try {
						getDb().rollback();
					} catch (SQLException e1) {
						log.error(e1);
					}
				}
			}
			try {
				getDb().setAutoCommit(true);
			} catch (SQLException e) {
				log.error(e);
			}
			log.debug("Inserted history for " + types.size() + " types for region " + region);
		}

		private List<MarketHistoryEntry> getHistory(int regionId, int typeId) {
			MarketApiWrapper mapiw = new MarketApiWrapper(getDb());
			List<GetMarketsRegionIdHistory200Ok> history = new ArrayList<>();
			int retry = 0;
			while (true) {
				try {
					history = mapiw.getMarketsRegionIdHistory(regionId, typeId);
					break;
				} catch (ApiException e) {
					if (e.getCode() == 404) {
						// slow down since ESI counts 404s towards the error count... (even on valid items!)
						try {
							Thread.sleep(5000);
						} catch (InterruptedException ie) {

						}
						break;
					}
					if (retry == 3) {
						log.error("Failed to retrieve history for type " + typeId + " for region " + regionId + ": " + e.getLocalizedMessage());
						log.debug(e);
						break;
					} else {
						retry++;
					}
				}
			}
			List<MarketHistoryEntry> entries = new ArrayList<>(history.size());
			for (GetMarketsRegionIdHistory200Ok h : history) {
				MarketHistoryEntry e = TypeUtil.convert(h);
				e.setTypeId(typeId);
				e.setRegionId(regionId);
				entries.add(e);
			}
			return entries;
		}

		private void calcStat(List<MarketHistoryEntry> hs, int typeId) {
			Date cutoff30 = new Date(System.currentTimeMillis() - 30L*24L*60L*60L*1000L);
			Date cutoff90 = new Date(System.currentTimeMillis() - 90L*24L*60L*60L*1000L);
			int sumVol30 = 0;
			int sumVol90 = 0;
			for (MarketHistoryEntry h : hs) {
				if (h.getDate().after(cutoff30)) {
					sumVol30 += h.getVolume();
				}
				if (h.getDate().after(cutoff90)) {
					sumVol90 += h.getVolume();
				}
			}
			MarketStat s = new MarketStat();
			s.setRegionId(region);
			s.setTypeId(typeId);
			s.setMa30(sumVol30 / 30);
			s.setMa90(sumVol90 / 90);
			try {
				MarketStatTable.upsert(getDb(), s);
				log.debug("Inserted market stats for type " + typeId + " for region " + region);
			} catch (SQLException e) {
				log.error("Failed to insert market stats for region " + region + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
		}

	}

}
