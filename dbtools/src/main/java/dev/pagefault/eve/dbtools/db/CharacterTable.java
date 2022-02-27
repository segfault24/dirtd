package dev.pagefault.eve.dbtools.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.pagefault.eve.dbtools.model.Character;
import dev.pagefault.eve.dbtools.util.Utils;

public class CharacterTable {

	private static final String UPSERT_SQL = "INSERT INTO `character` (`charId`,`charName`,`corpId`,`allianceId`,`birthday`) "
			+ "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE `corpId`=VALUES(`corpId`), `allianceId`=VALUES(`allianceId`)";
	private static final String SELECT_IDS_SQL = "SELECT `charId` FROM `character`";

	public static void upsert(Connection db, Character c) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(UPSERT_SQL);
		stmt.setInt(1, c.getCharId());
		stmt.setString(2, c.getCharName());
		stmt.setInt(3, c.getCorpId());
		stmt.setInt(4, c.getAllianceId());
		stmt.setDate(5, c.getBirthday());
		stmt.execute();
		Utils.closeQuietly(stmt);
	}

	public static List<Integer> getAllIds(Connection db) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(SELECT_IDS_SQL);
		ResultSet rs = stmt.executeQuery();
		List<Integer> ids = new ArrayList<Integer>();
		while (rs.next()) {
			ids.add(rs.getInt(1));
		}
		Utils.closeQuietly(rs);
		Utils.closeQuietly(stmt);
		return ids;
	}

}
