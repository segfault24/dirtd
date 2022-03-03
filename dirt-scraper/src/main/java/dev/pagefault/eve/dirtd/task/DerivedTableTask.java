package dev.pagefault.eve.dirtd.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

/**
 * Periodically refresh derived tables.
 * These could probably be stored procedures, tbh...
 * 
 * @author austin
 */
public class DerivedTableTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();

	private static final String[] DENTITY_SQLS = {
			"DROP TABLE IF EXISTS dentity_tmp;",
			"DROP TABLE IF EXISTS dentity_old;",
			"CREATE TABLE dentity_tmp LIKE dentity;",
			"INSERT INTO dentity_tmp SELECT `alliance`.`allianceId` AS `id`, `alliance`.`allianceName` AS `name` FROM `alliance`;",
			"INSERT INTO dentity_tmp SELECT `corporation`.`corpId` AS `id`,`corporation`.`corpName` AS `name` FROM `corporation`;",
			"INSERT INTO dentity_tmp SELECT `character`.`charId` AS `id`,`character`.`charName` AS `name` FROM `character`;",
			"RENAME TABLE dentity TO dentity_old, dentity_tmp TO dentity;",
			"DROP TABLE IF EXISTS dentity_old;"
	};

	private static final String[] DLOCATION_SQLS = {
			"DROP TABLE IF EXISTS dlocation_tmp;",
			"DROP TABLE IF EXISTS dlocation_old;",
			"CREATE TABLE dlocation_tmp LIKE dlocation;",
			"INSERT INTO dlocation_tmp SELECT `stationId` AS locationId, `stationName` AS locationName FROM `station`;",
			"INSERT INTO dlocation_tmp SELECT `structId` AS locationId, `structName` AS locationName FROM `structure`;",
			"RENAME TABLE dlocation TO dlocation_old, dlocation_tmp TO dlocation;",
			"DROP TABLE IF EXISTS dlocation_old;"
	};

	@Override
	public String getTaskName() {
		return "derived-tables";
	}

	@Override
	protected void runTask() {
		updateDerivedTable(DENTITY_SQLS);
		updateDerivedTable(DLOCATION_SQLS);
	}

	private void updateDerivedTable(String[] sqls) {
		// the initial DELETEs make this task self-correcting correcting if anything goes wrong
		try {
			for (String sql : sqls) {
				getDb().prepareStatement(sql).execute();
			}
		} catch (SQLException e) {
			log.error("Failed to update derived table: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}
}
