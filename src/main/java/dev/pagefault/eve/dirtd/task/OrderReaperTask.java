package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.CharOrderTable;
import dev.pagefault.eve.dbtools.db.MarketOrderTable;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;

public class OrderReaperTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	@Override
	public String getTaskName() {
		return "order-reaper";
	}

	@Override
	protected void runTask() {
		long maxAgeMinutes = Long.parseLong(Utils.getProperty(getDb(), DirtConstants.PROPERTY_MARKET_ORDERS_MAX_AGE));
		Timestamp olderThan = new Timestamp(System.currentTimeMillis() - maxAgeMinutes * 60 * 1000);
		try {
			int count = MarketOrderTable.deleteOldOrders(getDb(), olderThan);
			log.debug("Deleted " + count + " old market orders");
		} catch (SQLException e) {
			log.fatal("Failed to delete old market orders: " + e.getLocalizedMessage());
			log.debug(e);
		}
		try {
			int count = CharOrderTable.deleteOldOrders(getDb(), olderThan);
			log.debug("Deleted " + count + " old character orders");
		} catch (SQLException e) {
			log.fatal("Failed to delete old character orders: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
