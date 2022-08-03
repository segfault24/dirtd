package dev.pagefault.eve.dirtd.task;

import dev.pagefault.eve.dbtools.db.CharOrderTable;
import dev.pagefault.eve.dbtools.db.MarketOrderTable;
import dev.pagefault.eve.dbtools.db.OrderSetTable;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class OrderReaperTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();
	private static final long SLEEP_BETWEEN_DELETES_SEC = 1000;
	private static final long BATCH_SIZE = 10000;

	@Override
	public String getTaskName() {
		return "order-reaper";
	}

	@Override
	protected void runTask() {
		long maxAgeMinutes = Long.parseLong(Utils.getProperty(getDb(), DirtConstants.PROPERTY_MARKET_ORDERS_MAX_AGE));
		Timestamp olderThan = new Timestamp(System.currentTimeMillis() - maxAgeMinutes * 60 * 1000);

		// chunk delete by set, so we don't lock the database too long
		List<Integer> oldSetIds = null;
		try {
			oldSetIds = OrderSetTable.findOldSets(getDb(), olderThan);
			log.debug("Identified " + oldSetIds.size() + " order sets for deletion");
		} catch (SQLException e) {
			log.fatal("Failed to find old order sets");
			return;
		}

		int grandTotal = 0;
		for (int setId : oldSetIds) {
			int totalCount = 0;
			int count = 0;
			do {
				try {
					count = MarketOrderTable.deleteChunkOfSet(getDb(), setId, BATCH_SIZE);
					totalCount += count;
					log.debug("Deleted " + count + " orders for set " + setId + " (total so far: " + totalCount + ")");
					Thread.sleep(SLEEP_BETWEEN_DELETES_SEC);
				} catch (SQLException | InterruptedException e) {
					log.error("Failed to delete orders from set " + setId + ": " + e.getLocalizedMessage());
					log.debug(e);
					break;
				}
			} while (count != 0);
			try {
				OrderSetTable.deleteSet(getDb(), setId);
				log.debug("Deleted order set " + setId);
			} catch(SQLException e) {
				log.error("Failed to delete order set " + setId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
			grandTotal += totalCount;
		}
		log.debug("Deleted " + grandTotal + " orders in all");

		int count;
		try {
			count = CharOrderTable.deleteOldOrders(getDb(), olderThan);
			log.debug("Deleted " + count + " old character orders");
		} catch (SQLException e) {
			log.fatal("Failed to delete old character orders: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
