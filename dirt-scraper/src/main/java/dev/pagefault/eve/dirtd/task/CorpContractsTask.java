package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.db.CorpContractTable;
import dev.pagefault.eve.dbtools.model.Contract;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.ContractsApiWrapper;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import dev.pagefault.eve.dirtd.esi.auth.OAuthUtil;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.models.GetCorporationsCorporationIdContracts200Ok;

/**
 * Task to retrieve contracts for a corporation.
 * 
 * @author austin
 */
public class CorpContractsTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	public CorpContractsTask() {
	}

	@Override
	public String getTaskName() {
		return "corp-contracts";
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

		// iterate through the pages
		ContractsApiWrapper capiw = new ContractsApiWrapper(getDb());
		int page = 0;
		int totalContracts = 0;
		int numPages = 1;
		do {
			page++;
			List<GetCorporationsCorporationIdContracts200Ok> contracts = new ArrayList<>();
			try {
				ApiResponse<List<GetCorporationsCorporationIdContracts200Ok>> resp = capiw.getCorporationContracts(corpId, page, OAuthUtil.getAuthToken(getDb(), auth));
				contracts = resp.getData();
				numPages = EsiUtils.extractNumPages(resp);
			} catch (ApiException e) {
				if (e.getCode() == 304) {
					continue;
				} else {
					log.error("Failed to retrieve page " + page + " of contracts for corporation " + corpId + ": " + e.getLocalizedMessage());
					log.debug(e);
					break;
				}
			}
			log.debug("Retrieved " + contracts.size() + " contracts for corporation " + corpId + " page " + page);
			if (contracts.isEmpty()) {
				break;
			}

			totalContracts += contracts.size();
			List<Contract> l = new ArrayList<Contract>(contracts.size());
			for (GetCorporationsCorporationIdContracts200Ok gc : contracts) {
				Contract c = TypeUtil.convert(gc);
				l.add(c);
			}

			// check if contracts haven't ever been seen, so we can get the items
			// but don't queue the retrieval tasks until after we insert the contracts
			List<DirtTask> tasks = checkContractItems(auth, l, corpId);

			try {
				CorpContractTable.upsertMany(getDb(), l);
				log.debug("Inserted " + contracts.size() + " contracts for corporation " + corpId + " page " + page);
			} catch (SQLException e) {
				log.error("Unexpected failure while processing page " + page + " for corporation " + corpId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}

			// queue explicitly after contract insert because of foreign key constraint
			getExecutor().scheduleTasks(tasks);
		} while (page < numPages);

		log.debug("Inserted " + totalContracts + " total contracts for corporation " + corpId);

		// trigger a doctrine scan
		getExecutor().scheduleTask(new DoctrineTask());
	}

	private List<DirtTask> checkContractItems(OAuthUser auth, List<Contract> contracts, int corpId) {
		List<DirtTask> tasks = new ArrayList<DirtTask>();
		for (Contract contract : contracts) {
			if (contract.getType() == ContractType.ITEM_EXCHANGE) {
				try {
					Contract c = CorpContractTable.selectById(getDb(), contract.getContractId());
					if (c == null) {
						// we haven't seen this contract before, get the items
						tasks.add(new CorpContractItemsTask(corpId, contract.getContractId(), auth.getKeyId()));
					}
				} catch (SQLException e) {
					log.error("Failed to search for contract " + contract.getContractId()+ ": " + e.getLocalizedMessage());
					log.debug(e);
				}
			}
		}
		return tasks;
	}

}
