package dev.pagefault.eve.dirtd.task;

import dev.pagefault.eve.dirtd.esi.UniverseApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.PostUniverseNames200Ok;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Gets a list of character and corporation ids from wallet entries, contracts,
 * structures, etc and compares it to known ids to find any unresolved ids.
 * Those are then resolved via ESI and added to the database.
 * 
 * @author austin
 */
public class UnknownIdsTask extends DirtTask {

	private static final Logger log = LogManager.getLogger();

	private static final String SELECT_IDS_KNOWN_SQL = "SELECT `charId` FROM `character` "
			+ "UNION SELECT `corpId` FROM corporation";

	// keep ids in their rows, reduces calls
	private static final String[] SELECT_IDS_UNKNOWN_SQLS = {
			"SELECT issuerId, acceptorId, assigneeId, issuerCorpId FROM contract;",
			"SELECT issuerId, acceptorId, assigneeId, issuerCorpId FROM corpcontract;",
			"SELECT issuerId, issuerCorpId FROM publiccontract;",
			"SELECT corpId FROM structure;",
			"SELECT firstPartyId, secondPartyId FROM walletjournal;",
			"SELECT clientId FROM wallettransaction;"
	};

	private static final int BATCH_SIZE = 500;

	@Override
	public String getTaskName() {
		return "unknown-ids";
	}

	@Override
	protected void runTask() {
		// get list of all known corp + char ids in the db
		HashSet<Integer> knowns;
		try {
			knowns = getKnownIds(getDb());
		} catch (SQLException e) {
			log.fatal("Failed to scan database for char and corp ids: " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		log.debug("Found " + knowns.size() + " known char and corp ids");

		HashSet<Integer> search = new HashSet<>();
		for (String sql : SELECT_IDS_UNKNOWN_SQLS) {
			HashSet<Integer> unknowns;
			try {
				log.trace(sql);
				unknowns = getUnknownIds(getDb(), sql);
			} catch (SQLException e) {
				log.fatal("Failed to scan database for unknown ids: " + e.getLocalizedMessage());
				continue;
			}
			unknowns.forEach(id -> {
				if (!knowns.contains(id) && id != 0) {
					search.add(id);
				}
			});
		}
		log.debug("There are " + search.size() + " ids to be resolved");

		// pump through ESI's id resolver
		UniverseApiWrapper uapiw = new UniverseApiWrapper(getDb());

		List<Integer> search2 = new ArrayList<>(search);
		int batches = (search2.size() - 1) / BATCH_SIZE + 1;
		for (int i=0; i<batches; i++) {
			int startIdx = i * BATCH_SIZE;
			int endIdx = Math.min(startIdx + BATCH_SIZE, search2.size());
			List<Integer> sublist = search2.subList(startIdx, endIdx);

			List<PostUniverseNames200Ok> names;
			try {
				names = uapiw.postUniverseNames(sublist);
			} catch (ApiException e) {
				log.fatal("Failed to query ESI for ids: " + e.getResponseBody() + ": " + e.getLocalizedMessage());
				log.debug(e);
				return;
			}
	
			// spawn tasks
			for (PostUniverseNames200Ok name : names) {
				switch (name.getCategory()) {
				case CHARACTER:
					getExecutor().scheduleTask(new CharacterTask(name.getId()));
					break;
				case CORPORATION:
					getExecutor().scheduleTask(new CorporationTask(name.getId()));
					break;
				default:
					log.debug("Not a char or corp id: " + name.getId() + " " + name.getCategory().toString());
					break;
				}
			}
		}
	}

	private HashSet<Integer> getKnownIds(Connection db) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(SELECT_IDS_KNOWN_SQL);
		ResultSet rs = stmt.executeQuery();
		HashSet<Integer> ids = new HashSet<>();
		while (rs.next()) {
			ids.add(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		return ids;
	}

	private HashSet<Integer> getUnknownIds(Connection db, String sql) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		HashSet<Integer> ids = new HashSet<>();
		int c = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i=1; i<=c; i++) {
				ids.add(rs.getInt(i));
			}
		}
		rs.close();
		stmt.close();
		return ids;
	}

}
