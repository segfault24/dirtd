package dev.pagefault.eve.dbtools.db;

import dev.pagefault.eve.dbtools.model.MarketOrder;
import dev.pagefault.eve.dbtools.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class MarketOrderTable {

	private static final String UPSERT_SQL = "INSERT INTO marketorder ("
			+ "`issued`,`range`,`isBuyOrder`,`duration`,`orderId`,`volumeRemain`,`minVolume`,"
			+ "`typeId`,`volumeTotal`,`locationId`,`price`,`regionId`,`retrieved`"
			+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE "
			+ "`volumeRemain`=VALUES(`volumeRemain`),`price`=VALUES(`price`),"
			+ "`retrieved`=VALUES(`retrieved`),`issued`=VALUES(`issued`)";

	private static final int BATCH_SIZE = 1000;

	public static void upsertMany(Connection db, Collection<MarketOrder> os) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(UPSERT_SQL);
		int count = 0;
		for (MarketOrder o : os) {
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
			stmt.addBatch();
			count++;
			if (count % BATCH_SIZE == 0 || count == os.size()) {
				stmt.executeBatch();
			}
		}
		Utils.closeQuietly(stmt);
	}

}
