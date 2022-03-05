package dev.pagefault.eve.dirtd.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Periodically refresh the materialized view tables for market prices.
 * These could probably be stored procedures, tbh...
 *
 * @author austin
 */
public class MaterializedPriceViewTask extends DirtTask {

    private static final Logger log = LogManager.getLogger();

    private static final String[] SETUP_SQLS = {
            "DROP TABLE IF EXISTS %s_tmp;",
            "DROP TABLE IF EXISTS %s_old;",
            "CREATE TABLE %s_tmp LIKE %<s;"
    };
    private static final String INSERT_SQL = "INSERT INTO %s_tmp"
            + " SELECT `typeId`, %s(`price`) FROM `marketorder`"
            + " WHERE `setId` = (SELECT `setId` FROM `latestset` WHERE `regionId` = ?)"
            + " AND `locationId` IN (%s) AND `isBuyOrder` = ?"
            + " GROUP BY `typeId`;";

    private static final String[] FINISH_SQLS = {
            "RENAME TABLE %s TO %<s_old, %<s_tmp TO %<s;",
            "DROP TABLE IF EXISTS %s_old;"
    };

    private final String tableName;
    private final int regionId;
    private final List<Long> locationIds;
    private final boolean isBuyOrder;

    public MaterializedPriceViewTask(String tableName, int regionId, List<Long> locationIds, boolean isBuyOrder) {
        this.tableName = tableName;
        this.regionId = regionId;
        this.locationIds = locationIds;
        this.isBuyOrder = isBuyOrder;
    }

    @Override
    public String getTaskName() {
        return "order-view-" + locationIds.get(0) + (isBuyOrder ? "-buy" : "-sell");
    }

    @Override
    protected void runTask() {
        try {
            // the initial DELETEs make this task self-correcting if anything goes wrong
            for (String sql : SETUP_SQLS) {
                String sql_tmp = String.format(sql, tableName);
                log.trace(sql_tmp);
                getDb().prepareStatement(sql_tmp).execute();
            }

            String isql = String.format(INSERT_SQL,
                    tableName,
                    isBuyOrder ? "MAX" : "MIN",
                    locationIds.stream().map(v -> "?").collect(Collectors.joining(","))
                    );
            log.trace(isql);
            PreparedStatement stmt = getDb().prepareStatement(isql);
            int i = 1;
            stmt.setInt(i++, regionId);
            for (long location : locationIds) {
                stmt.setLong(i++, location);
            }
            stmt.setBoolean(i, isBuyOrder);
            stmt.execute();

            for (String sql : FINISH_SQLS) {
                String sql_tmp = String.format(sql, tableName);
                log.trace(sql_tmp);
                getDb().prepareStatement(sql_tmp).execute();
            }
        } catch (SQLException e) {
            log.error("Failed to update materialized view " + tableName + ": " + e.getLocalizedMessage());
            log.debug(e);
        }
    }
}
