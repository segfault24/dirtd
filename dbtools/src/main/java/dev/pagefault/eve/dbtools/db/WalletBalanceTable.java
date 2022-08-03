package dev.pagefault.eve.dbtools.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dev.pagefault.eve.dbtools.util.Utils;

public class WalletBalanceTable {

	private static final String UPSERT_SQL = "INSERT INTO walletbalance (`charId`,`balance`)"
			+ " VALUES (?,?) ON DUPLICATE KEY UPDATE `balance`=VALUES(`balance`)";

	public static boolean upsert(Connection db, int charId, Double balance) {
		boolean result = true;
		PreparedStatement stmt = null;
		try {
			stmt = db.prepareStatement(UPSERT_SQL);
			stmt.setInt(1, charId);
			stmt.setDouble(2, balance);
			stmt.execute();
		} catch (SQLException e) {
			result = false;
		} finally {
			Utils.closeQuietly(stmt);
		}
		return result;
	}

}
