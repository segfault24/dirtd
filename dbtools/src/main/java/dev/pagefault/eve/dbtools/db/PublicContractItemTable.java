package dev.pagefault.eve.dbtools.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dev.pagefault.eve.dbtools.model.PublicContractItem;
import dev.pagefault.eve.dbtools.util.Utils;

public class PublicContractItemTable {

	private static final String INSERT_SQL = "INSERT INTO publiccontractitem ("
			+ "`contractId`,`typeId`,`quantity`,`recordId`,`included`,`isBpc`,"
			+ "`itemId`,`matEfficiency`,`timeEfficiency`,`runs`) VALUES ("
			+ "?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE `quantity`=`quantity`";

	public static void upsertMany(Connection db, List<PublicContractItem> items) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(INSERT_SQL);
		for (PublicContractItem i : items) {
			stmt.setInt(1, i.getContractId());
			stmt.setInt(2, i.getTypeId());
			stmt.setInt(3, i.getQuantity());
			stmt.setLong(4, i.getRecordId());
			stmt.setBoolean(5, i.isIncluded());
			stmt.setBoolean(6, i.isBpc());
			stmt.setLong(7, i.getItemId());
			stmt.setInt(8, i.getMaterialEfficiency());
			stmt.setInt(9, i.getTimeEfficiency());
			stmt.setInt(10, i.getRuns());
			stmt.addBatch();
		}
		stmt.executeBatch();
		Utils.closeQuietly(stmt);
	}

}
