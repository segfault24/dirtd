package dev.pagefault.eve.dirtd;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.daemon.TaskExecutor;
import dev.pagefault.eve.dirtd.task.CorpContractsItemRetryTask;
import dev.pagefault.eve.dirtd.task.CorpContractsTask;
import dev.pagefault.eve.dirtd.task.DerivedTableTask;
import dev.pagefault.eve.dirtd.task.InsurancePricesTask;
import dev.pagefault.eve.dirtd.task.InvMarketGroupsTask;
import dev.pagefault.eve.dirtd.task.InvTypesTask;
import dev.pagefault.eve.dirtd.task.MERTask;
import dev.pagefault.eve.dirtd.task.MarketHistoryTask;
import dev.pagefault.eve.dirtd.task.MarketRegionOrdersTask;
import dev.pagefault.eve.dirtd.task.MetaCharacterMarketTask;
import dev.pagefault.eve.dirtd.task.MetaWalletTask;
import dev.pagefault.eve.dirtd.task.OrderReaperTask;
import dev.pagefault.eve.dirtd.task.PublicContractsTask;
import dev.pagefault.eve.dirtd.task.PublicStructuresTask;
import dev.pagefault.eve.dirtd.task.UnknownIdsTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author austin
 */
public class DirtDaemon {

	private static final Logger log = LogManager.getLogger();

	private boolean startWithPeriodicTasks = true;
	private final DbPool dbPool;
	private final TaskExecutor executor;

	public DirtDaemon(int port, boolean startWithPeriodicTasks) {
		this.startWithPeriodicTasks = startWithPeriodicTasks;
		dbPool = new DbPool(new DbInfo());
		executor = new TaskExecutor(dbPool);
	}

	public void start() throws IOException, SQLException {
		log.info("=======================================");
		log.warn("==  dirtd task executor starting up  ==");
		log.info("=======================================");
		executor.init();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				dbPool.closeAll();
				try {
					DirtDaemon.this.stop();
				} catch (InterruptedException e) {
					log.error(e);
				}
			}
		});

		if (startWithPeriodicTasks) {
			log.info("Initializing periodic tasks");
			initPeriodicTasks();
		}
	}

	public void stop() throws InterruptedException {
		if (executor != null) {
			executor.stopAll();
		}
	}

	private void initPeriodicTasks() throws SQLException {
		Connection db = dbPool.acquire();

		// public market orders for specific regions
		List<Integer> regions = Utils.parseIntList(Utils.getProperty(db, DirtConstants.PROPERTY_MARKET_ORDERS_REGIONS));
		int period = Utils.getIntProperty(db, DirtConstants.PROPERTY_MARKET_ORDERS_PERIOD);

		for (Integer regionId : regions) {
			executor.schedulePeriodicTask(db, new MarketRegionOrdersTask(regionId), period);
		}

		// auto-delete old market orders that might not be cleaned up elsewhere
		executor.schedulePeriodicTask(db, new OrderReaperTask(), 30);

		// auto-regenerate derived tables periodically
		executor.schedulePeriodicTask(db, new DerivedTableTask(), 360);

		// market history for specific regions
		regions = Utils.parseIntList(Utils.getProperty(db, DirtConstants.PROPERTY_MARKET_HISTORY_REGIONS));
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_MARKET_HISTORY_PERIOD);
		for (int regionId : regions) {
			executor.schedulePeriodicTask(db, new MarketHistoryTask(regionId), period);
		}

		// public structure info
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_PUBLIC_STRUCTURES_PERIOD);
		executor.schedulePeriodicTask(db, new PublicStructuresTask(), period);

		// insurance price info
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_INSURANCE_PRICES_PERIOD);
		executor.schedulePeriodicTask(db, new InsurancePricesTask(), period);

		// type & group info
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_TYPE_INFO_PERIOD);
		executor.schedulePeriodicTask(db, new InvTypesTask(), period);
		executor.schedulePeriodicTask(db, new InvMarketGroupsTask(), period);

		// monthly econ report
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_MER_PERIOD);
		executor.schedulePeriodicTask(db, new MERTask(), period);

		// character wallet
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_WALLET_PERIOD);
		executor.schedulePeriodicTask(db, new MetaWalletTask(), period);

		// character orders and contracts
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_CHARACTER_MARKET_PERIOD);
		executor.schedulePeriodicTask(db, new MetaCharacterMarketTask(), period);

		// corporation contracts
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_CORP_CONTRACTS_PERIOD);
		executor.schedulePeriodicTask(db, new CorpContractsTask(), period);

		// contract items retry
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_CORP_CONTRACTS_PERIOD);
		executor.schedulePeriodicTask(db, new CorpContractsItemRetryTask(), period * 4);

		// public contracts
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_PUBLIC_CONTRACTS_PERIOD);
		executor.schedulePeriodicTask(db, new PublicContractsTask(), period);

		// unknown ids resolution
		period = Utils.getIntProperty(db, DirtConstants.PROPERTY_UNKNOWN_IDS_PERIOD);
		executor.schedulePeriodicTask(db, new UnknownIdsTask(), period);

		dbPool.release(db);
	}

	public static void main(String[] args) throws Exception {
		boolean notasks = false;
		boolean help = false;
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--notasks")) {
				notasks = true;
			} else if (arg.equalsIgnoreCase("--help")) {
				help = true;
			} else {
				System.err.println("Unknown option \"" + arg + "\"");
				help = true;
			}
		}

		if (help) {
			System.out.println("DirtTaskDaemon");
			System.out.println("  --notasks   dont start with any tasks");
			System.out.println("  --help      show this message");
			return;
		}

		DirtDaemon d = new DirtDaemon(6524, !notasks);
		d.start();
	}

}
