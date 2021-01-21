package dev.pagefault.eve.dirtd.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.PublicContractItemTable;
import dev.pagefault.eve.dbtools.model.PublicContractItem;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.ContractsApiWrapper;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.models.GetContractsPublicItemsContractId200Ok;

/**
 * Task to retrieve items in a public contract.
 * 
 * @author austin
 */
public class PublicContractItemsTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private static final int SLEEP_HACK = 5000;

	private int contractId;

	public PublicContractItemsTask(int contractId) {
		this.contractId = contractId;
	}

	@Override
	public String getTaskName() {
		return "public-contract-items-" + contractId;
	}

	@Override
	protected void runTask() {
		// iterate through the pages
		ContractsApiWrapper capiw = new ContractsApiWrapper(getDb());
		int page = 0;
		int totalItems = 0;
		int numPages = 1;
		do {
			page++;
			List<GetContractsPublicItemsContractId200Ok> items = new ArrayList<>();
			try {
				ApiResponse<List<GetContractsPublicItemsContractId200Ok>> resp = capiw.getPublicContractItems(contractId, page);
				items = resp.getData();
				numPages = EsiUtils.extractNumPages(resp);
				log.debug("detected " + numPages + " pages in header");
				try {
					Thread.sleep(SLEEP_HACK);
				} catch (InterruptedException e) {
				}
			} catch (ApiException e) {
				if (e.getCode() == 304) {
					break;
				} else {
					log.error("Failed to retrieve items for contract " + contractId + ": " + e.getLocalizedMessage());
					log.debug(e);
					break;
				}
			}
			log.debug("Retrieved " + items.size() + " items for contract " + contractId + " page " + page);
			if (items.isEmpty()) {
				break;
			}

			totalItems += items.size();
			List<PublicContractItem> l = new ArrayList<PublicContractItem>(items.size());
			for (GetContractsPublicItemsContractId200Ok i : items) {
				PublicContractItem p = TypeUtil.convert(i);
				p.setContractId(contractId);
				l.add(p);
			}

			try {
				getDb().setAutoCommit(false);
				getDb().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				PublicContractItemTable.upsertMany(getDb(), l);
				getDb().commit();
				getDb().setAutoCommit(true);
				log.debug("Inserted " + items.size() + " items for contract " + contractId + " page " + page);
			} catch (SQLException e) {
				log.error("Unexpected failure while processing page " + page + " for contract " + contractId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
		} while (page < numPages);

		log.debug("Inserted " + totalItems + " total items for contract " + contractId);
	}

}
