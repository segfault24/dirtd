package dev.pagefault.eve.dirtd.task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.model.Contract;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;

/**
 * Task to retry item retrieval for exchange contracts.
 * 
 * @author austin
 */
public class CorpContractsItemRetryTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	// outstanding and finished exchange contracts that have no items in the db within the last 3 months
	private static final String SELECT_SQL = "SELECT c.contractid FROM corpcontract c"
			+ " LEFT JOIN corpcontractitem ci ON ci.contractId=c.contractId"
			+ " WHERE ci.contractItemId IS NULL AND c.type=" + Contract.ContractType.ITEM_EXCHANGE.getValue()
			+ " AND c.status IN (" + Contract.ContractStatus.OUTSTANDING.getValue()
			+ "," + Contract.ContractStatus.FINISHED.getValue() + ")"
			+ " AND c.dateIssued > DATE_ADD(NOW(), INTERVAL -3 MONTH)";

	public CorpContractsItemRetryTask() {
	}

	@Override
	public String getTaskName() {
		return "corp-contracts-item-retry";
	}

	@Override
	protected void runTask() {
		// get api auth info
		int keyId = Integer.parseInt(Utils.getProperty(getDb(), DirtConstants.PROPERTY_SCRAPER_KEY_ID));
		OAuthUser auth;
		try {
			auth = ApiAuthTable.getUserByKeyId(getDb(), keyId);
			if (auth == null) {
				log.fatal("No auth details found for key=" + keyId);
				return;
			}
		} catch (SQLException e) {
			log.fatal("Failed to get auth details for key=" + keyId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}

		int corpId = Integer.parseInt(Utils.getProperty(getDb(), DirtConstants.PROPERTY_SCRAPER_CORP_ID));

		// get exchange contracts with no items
		// then queue the items task
		try {
			PreparedStatement stmt = getDb().prepareStatement(SELECT_SQL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int contractId = rs.getInt(1);
				CorpContractItemsTask t = new CorpContractItemsTask(corpId, contractId, auth.getKeyId());
				getExecutor().scheduleTask(t);
			}
			Utils.closeQuietly(rs);
			Utils.closeQuietly(stmt);
		} catch (SQLException e) {
			log.fatal("Failed to build contract item tasks: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
