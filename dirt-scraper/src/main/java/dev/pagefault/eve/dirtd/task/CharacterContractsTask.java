package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.db.ContractTable;
import dev.pagefault.eve.dbtools.model.Contract;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.ContractsApiWrapper;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import dev.pagefault.eve.dirtd.esi.auth.OAuthUtil;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.models.GetCharactersCharacterIdContracts200Ok;

/**
 * Task to retrieve contracts for a character.
 * 
 * @author austin
 */
public class CharacterContractsTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private int charId;

	public CharacterContractsTask(int charId) {
		this.charId = charId;
	}

	@Override
	public String getTaskName() {
		return "character-contracts-" + charId;
	}

	@Override
	protected void runTask() {
		// get api auth info
		OAuthUser auth;
		try {
			auth = ApiAuthTable.getUserByCharId(getDb(), charId);
			if (auth == null) {
				log.fatal("No auth details found for char=" + charId);
				return;
			}
		} catch (SQLException e) {
			log.fatal("Failed to get auth details for char=" + charId);
			return;
		}

		// get the user's other characters too
		List<Integer> otherCharIds;
		try {
			otherCharIds = ApiAuthTable.getCharsByUserId(getDb(), auth.getUserId());
			if (otherCharIds == null) {
				log.fatal("No auth details found for user=" + auth.getUserId());
				return;
			}
		} catch (SQLException e) {
			log.fatal("Failed to get auth details for user=" + auth.getUserId());
			return;
		}

		// iterate through the pages
		ContractsApiWrapper capiw = new ContractsApiWrapper(getDb());
		int page = 0;
		int totalContracts = 0;
		int numPages = 1;
		do {
			page++;
			List<GetCharactersCharacterIdContracts200Ok> contracts = new ArrayList<>();
			try {
				ApiResponse<List<GetCharactersCharacterIdContracts200Ok>> resp = capiw.getCharacterContracts(charId, page, OAuthUtil.getAuthToken(getDb(), auth));
				contracts = resp.getData();
				numPages = EsiUtils.extractNumPages(resp);
			} catch (ApiException e) {
				if (e.getCode() == 304) {
					continue;
				} else {
					log.error("Failed to retrieve page " + page + " of contracts for character " + charId + ": " + e.getLocalizedMessage());
					log.debug(e);
					break;
				}
			}
			log.debug("Retrieved " + contracts.size() + " contracts for character " + charId + " page " + page);
			if (contracts.isEmpty()) {
				break;
			}

			totalContracts += contracts.size();
			List<Contract> l = new ArrayList<Contract>(contracts.size());
			for (GetCharactersCharacterIdContracts200Ok gc : contracts) {
				Contract c = TypeUtil.convert(gc);
				l.add(c);
			}

			// check if contracts haven't ever been seen, so we can get the items
			// but don't queue the retrieval tasks until after we insert the contracts
			List<DirtTask> tasks = checkContractItems(auth, l);

			try {
				ContractTable.upsertMany(getDb(), l);
				log.debug("Inserted " + contracts.size() + " contracts for character " + charId + " page " + page);
			} catch (SQLException e) {
				log.error("Unexpected failure while processing page " + page + " for character " + charId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}

			// queue explicitly after contract insert because of foreign key constraint
			getExecutor().scheduleTasks(tasks);
		} while (page < numPages);

		log.debug("Inserted " + totalContracts + " total contracts for character " + charId);
	}

	private List<DirtTask> checkContractItems(OAuthUser auth, List<Contract> contracts) {
		List<DirtTask> tasks = new ArrayList<DirtTask>();
		for (Contract contract : contracts) {
			if (contract.getType() == ContractType.ITEM_EXCHANGE) {
				try {
					Contract c = ContractTable.selectById(getDb(), contract.getContractId());
					if (c == null) {
						// we haven't seen this contract before, get the items
						tasks.add(new ContractItemsTask(contract.getContractId(), auth.getKeyId()));
					}
				} catch (SQLException e) {
					log.error("Failed to search for contract", e);
				}
			}
		}
		return tasks;
	}

}
