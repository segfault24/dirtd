package dev.pagefault.eve.dirtd.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.PublicContractTable;
import dev.pagefault.eve.dbtools.model.PublicContract;
import dev.pagefault.eve.dbtools.model.Contract.ContractStatus;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.ContractsApiWrapper;
import dev.pagefault.eve.dirtd.esi.EsiUtils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.models.GetContractsPublicRegionId200Ok;

/**
 * Task to get all public contracts, iterated by region
 * 
 * @author austin
 */
public class PublicContractsTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private static final int[] regions = { 10000001, 10000002, 10000003, 10000005, 10000006, 10000007, 10000008,
			10000009, 10000010, 10000011, 10000012, 10000013, 10000014, 10000015, 10000016, 10000018, 10000020,
			10000021, 10000022, 10000023, 10000025, 10000027, 10000028, 10000029, 10000030, 10000031, 10000032,
			10000033, 10000034, 10000035, 10000036, 10000037, 10000038, 10000039, 10000040, 10000041, 10000042,
			10000043, 10000044, 10000045, 10000046, 10000047, 10000048, 10000049, 10000050, 10000051, 10000052,
			10000053, 10000054, 10000055, 10000056, 10000057, 10000058, 10000059, 10000060, 10000061, 10000062,
			10000063, 10000064, 10000065, 10000066, 10000067, 10000068, 10000069 };

	@Override
	public String getTaskName() {
		return "public-contracts";
	}

	@Override
	protected void runTask() {
		ContractsApiWrapper capiw = new ContractsApiWrapper(getDb());
		Timestamp now = new Timestamp(System.currentTimeMillis() - 1000);

		int totalContracts = 0;
		for (int region : regions) {
			int page = 0;
			int numPages = 1;
			int totalRegionContracts = 0;
			do {
				page++;
				Timestamp retrieved = new Timestamp(System.currentTimeMillis());
				List<GetContractsPublicRegionId200Ok> contracts = new ArrayList<>();
				try {
					ApiResponse<List<GetContractsPublicRegionId200Ok>> resp = capiw.getPublicContracts(region, page);
					contracts = resp.getData();
					numPages = EsiUtils.extractNumPages(resp);
					log.debug("detected " + numPages + " pages in header");
				} catch (ApiException e) {
					if (e.getCode() == 304) {
						break;
					} else {
						log.error("Failed to retrieve page " + page + " of contracts for region " + region + ": "
								+ e.getLocalizedMessage());
						log.debug(e);
						break;
					}
				}
				log.debug("Retrieved " + contracts.size() + " contracts for region " + region + " page " + page);
				if (contracts.isEmpty()) {
					break;
				}

				totalRegionContracts += contracts.size();
				totalContracts += contracts.size();
				List<PublicContract> l = new ArrayList<PublicContract>(contracts.size());
				for (GetContractsPublicRegionId200Ok c : contracts) {
					PublicContract p = TypeUtil.convert(c);
					p.setStatus(ContractStatus.OUTSTANDING);
					p.setRegionId(region);
					p.setLastSeen(retrieved);
					l.add(p);
				}

				// check if contracts haven't ever been seen, so we can get the items
				// but don't queue the retrieval tasks until after we insert the contracts
				List<DirtTask> tasks = checkContractItems(l);

				try {
					getDb().setAutoCommit(false);
					getDb().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
					PublicContractTable.upsertMany(getDb(), l);
					getDb().commit();
					getDb().setAutoCommit(true);
					log.debug("Inserted " + l.size() + " contracts for region " + region + " page " + page);
				} catch (SQLException e) {
					log.error("Unexpected failure while processing page " + page + " for region " + region + ": " + e.getLocalizedMessage());
					log.debug(e);
					continue; // skips item retrieval if something went wrong
				}

				// queue explicitly after contract insert because of foreign key constraint
				getExecutor().scheduleTasks(tasks);
			} while (page < numPages);
			log.debug("Inserted " + totalRegionContracts + " total contracts for region " + region);
		}
		log.debug("Inserted " + totalContracts + " total contracts for all regions");

		// since public contracts don't tell us when a contract is anything but
		// outstanding, assume that any contract not seen in the latest poll is
		// completed. if something goes wrong, future polls will change it back to
		// outstanding eventually.
		try {
			int count = PublicContractTable.updateStatus(getDb(), now);
			log.debug("Updated status for " + count + " old contracts");
		} catch (SQLException e) {
			log.fatal("Failed to update status for old contracts: " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

	private List<DirtTask> checkContractItems(List<PublicContract> contracts) {
		List<DirtTask> tasks = new ArrayList<DirtTask>();
		for (PublicContract contract : contracts) {
			if (contract.getType() == ContractType.ITEM_EXCHANGE) {
				try {
					PublicContract c = PublicContractTable.selectById(getDb(), contract.getContractId());
					if (c == null) {
						// we haven't seen this contract before, get the items
						tasks.add(new PublicContractItemsTask(contract.getContractId()));
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
