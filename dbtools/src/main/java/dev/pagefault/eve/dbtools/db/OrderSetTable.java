package dev.pagefault.eve.dbtools.db;

import dev.pagefault.eve.dbtools.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class OrderSetTable {

    private static final String INSERT_SQL = "INSERT INTO orderset (`regionId`,`retrieved`) VALUES (?,?)";
    private static final String UPSERT_LATEST_SQL = "INSERT INTO latestset (`regionId`,`setId`) VALUES (?,?)" +
            " ON DUPLICATE KEY UPDATE `setId`=VALUES(`setId`)";
    private static final String DELETE_OLD_SQL = "DELETE FROM orderset WHERE `retrieved`<? LIMIT 1";

    public static int buildNewSet(Connection db, int regionId) throws SQLException {
        PreparedStatement stmt = db.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, regionId);
        stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        int setId = rs.getInt(1);
        Utils.closeQuietly(stmt);
        return setId;
    }

    public static void updateLatest(Connection db, int regionId, int setId) throws SQLException {
        PreparedStatement stmt = db.prepareStatement(UPSERT_LATEST_SQL);
        stmt.setInt(1, regionId);
        stmt.setInt(2, setId);
        stmt.executeUpdate();
    }

    public static int deleteOneOldSet(Connection db, Timestamp olderThan) throws SQLException {
        PreparedStatement stmt = db.prepareStatement(DELETE_OLD_SQL);
        stmt.setTimestamp(1, olderThan);
        return stmt.executeUpdate();
    }

}
