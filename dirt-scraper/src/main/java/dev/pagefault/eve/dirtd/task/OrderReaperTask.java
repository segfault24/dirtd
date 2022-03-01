package dev.pagefault.eve.dirtd.task;

import dev.pagefault.eve.dbtools.db.CharOrderTable;
import dev.pagefault.eve.dbtools.db.OrderSetTable;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderReaperTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();
	private static final long SLEEP_BETWEEN_DELETES_SEC = 5000;

	@Override
	public String getTaskName() {
		return "order-reaper";
	}

	@Override
	protected void runTask() {
		long maxAgeMinutes = Long.parseLong(Utils.getProperty(getDb(), DirtConstants.PROPERTY_MARKET_ORDERS_MAX_AGE));
		Timestamp olderThan = new Timestamp(System.currentTimeMillis() - maxAgeMinutes * 60 * 1000);

		// delete one at a time, so we don't lock the database too long
		int totalCount = 0;
		int count = 0;
		do {
			try {
				count = OrderSetTable.deleteOneOldSet(getDb(), olderThan);
				totalCount += count;
				Thread.sleep(SLEEP_BETWEEN_DELETES_SEC);
			} catch (SQLException | InterruptedException e) {
				log.fatal("Failed to delete old order sets: " + e.getLocalizedMessage());
				log.debug(e);
				break;
			}
		} while (count != 0);
		log.debug("Deleted " + totalCount + " old order sets");

		try {
			count = CharOrderTable.deleteOldOrders(getDb(), olderThan);
			log.debug("Deleted " + count + " old character orders");
		} catch (SQLException e) {
			log.fatal("Failed to delete old character orders: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
