package dev.pagefault.eve.dirtd.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.db.CorpContractItemTable;
import dev.pagefault.eve.dbtools.model.ContractItem;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.ContractsApiWrapper;
import dev.pagefault.eve.dirtd.esi.auth.OAuthUtil;
import net.evetech.ApiException;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdItems200Ok;

/**
 * Task to retrieve items in a contract.
 * 
 * @author austin
 */
public class CorpContractItemsTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private static final int SLEEP_HACK = 10000;

	private int corpId;
	private int contractId;
	private int keyId;

	public CorpContractItemsTask(int corpId, int contractId, int keyId) {
		this.corpId = corpId;
		this.contractId = contractId;
		this.keyId = keyId;
	}

	@Override
	public String getTaskName() {
		return "corp-contract-items-" + contractId;
	}

	@Override
	protected void runTask() {
		// get api auth info
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

		ContractsApiWrapper capiw = new ContractsApiWrapper(getDb());
		List<GetCorporationsCorporationIdContractsContractIdItems200Ok> items;
		try {
			items = capiw.getCorporationContractItems(corpId, contractId, OAuthUtil.getAuthToken(getDb(), auth));
			try {
				Thread.sleep(SLEEP_HACK);
			} catch (InterruptedException e) {
			}
		} catch (ApiException e) {
			log.error("Failed to retrieve items for contract " + contractId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}
		log.debug("Retrieved " + items.size() + " items for contract " + contractId);

		List<ContractItem> l = new ArrayList<ContractItem>(items.size());
		for (GetCorporationsCorporationIdContractsContractIdItems200Ok i : items) {
			ContractItem ci = TypeUtil.convert(i);
			ci.setContractId(contractId);
			l.add(ci);
		}

		try {
			getDb().setAutoCommit(false);
			getDb().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			CorpContractItemTable.deleteByContractId(getDb(), contractId);
			CorpContractItemTable.insertMany(getDb(), l);
			getDb().commit();
			getDb().setAutoCommit(true);
			log.debug("Inserted " + l.size() + " items for contract " + contractId);
		} catch (SQLException e) {
			log.error("Unexpected failure while processing items for contract " + contractId + ": " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
