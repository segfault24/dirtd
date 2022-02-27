package dev.pagefault.eve.dbtools.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import dev.pagefault.eve.dbtools.model.Contract;
import dev.pagefault.eve.dbtools.model.PublicContract;
import dev.pagefault.eve.dbtools.model.Contract.ContractStatus;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;
import dev.pagefault.eve.dbtools.util.Utils;

public class PublicContractTable {

	private static final String SELECT_BY_ID_SQL = "SELECT `contractId`,`type`,`status`,`issuerId`,"
			+ "`issuerCorpId`,`forCorp`,`dateIssued`,`dateExpired`,`title`,`price`,`regionId`,"
			+ "`startLocationId`,`endLocationId`,`daysToComplete`,`reward`,`collateral`,`buyout`,"
			+ "`volume`,`lastSeen` FROM publiccontract WHERE contractId=?";

	private static final String INSERT_SQL = "INSERT INTO publiccontract ("
			+ "`contractId`,`type`,`status`,`issuerId`,`issuerCorpId`,`forCorp`,`dateIssued`,"
			+ "`dateExpired`,`title`,`price`,`regionId`,`startLocationId`,`endLocationId`,"
			+ "`daysToComplete`,`reward`,`collateral`,`buyout`,`volume`,`lastSeen`"
			+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE"
			+ " `lastSeen`=VALUES(`lastSeen`), `status`=VALUES(`status`)";

	private static final String UPDATE_COMPLETED_SQL = "UPDATE publiccontract SET `status`="
			+ Contract.ContractStatus.FINISHED.getValue() + " WHERE `lastSeen`<?";

	private static final int BATCH_SIZE = 1000;

	public static void upsertMany(Connection db, List<PublicContract> l) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(INSERT_SQL);
		int count = 0;
		for (PublicContract c : l) {
			stmt.setInt(1, c.getContractId());
			stmt.setInt(2, c.getType().getValue());
			stmt.setInt(3, c.getStatus().getValue());
			stmt.setInt(4, c.getIssuerId());
			stmt.setInt(5, c.getIssuerCorpId());
			stmt.setBoolean(6, c.isForCorp());
			stmt.setTimestamp(7, c.getDateIssued());
			stmt.setTimestamp(8, c.getDateExpired());
			stmt.setString(9, c.getTitle());
			stmt.setDouble(10, c.getPrice());
			stmt.setInt(11, c.getRegionId());
			stmt.setLong(12, c.getStartLocationId());
			stmt.setLong(13, c.getEndLocationId());
			stmt.setInt(14, c.getDaysToComplete());
			stmt.setDouble(15, c.getReward());
			stmt.setDouble(16, c.getCollateral());
			stmt.setDouble(17, c.getBuyout());
			stmt.setDouble(18, c.getVolume());
			stmt.setTimestamp(19, c.getLastSeen());
			stmt.addBatch();
			count++;
			if (count % BATCH_SIZE == 0 || count == l.size()) {
				stmt.executeBatch();
			}
		}
		Utils.closeQuietly(stmt);
	}

	public static int updateStatus(Connection db, Timestamp before) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(UPDATE_COMPLETED_SQL);
		stmt.setTimestamp(1, before);
		int retval = stmt.executeUpdate();
		Utils.closeQuietly(stmt);
		return retval;
	}

	public static PublicContract selectById(Connection db, int contractId) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(SELECT_BY_ID_SQL);
		stmt.setInt(1, contractId);
		ResultSet rs = stmt.executeQuery();
		PublicContract c = null;
		if (rs.next()) {
			c = new PublicContract();
			c.setContractId(rs.getInt(1));
			c.setType(ContractType.valueOf(rs.getInt(2)));
			c.setStatus(ContractStatus.valueOf(rs.getInt(3)));
			c.setIssuerId(rs.getInt(4));
			c.setIssuerCorpId(rs.getInt(5));
			c.setForCorp(rs.getBoolean(6));
			c.setDateIssued(rs.getTimestamp(7));
			c.setDateExpired(rs.getTimestamp(8));
			c.setTitle(rs.getString(9));
			c.setPrice(rs.getDouble(10));
			c.setRegionId(rs.getInt(11));
			c.setStartLocationId(rs.getLong(12));
			c.setEndLocationId(rs.getLong(13));
			c.setDaysToComplete(rs.getInt(14));
			c.setReward(rs.getDouble(15));
			c.setCollateral(rs.getDouble(16));
			c.setBuyout(rs.getDouble(17));
			c.setVolume(rs.getDouble(18));
			c.setLastSeen(rs.getTimestamp(19));
		}
		Utils.closeQuietly(rs);
		Utils.closeQuietly(stmt);
		return c;
	}

}
