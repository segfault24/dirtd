package dev.pagefault.eve.dirtd;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import dev.pagefault.eve.dbtools.db.AlertTable;
import dev.pagefault.eve.dbtools.model.Alert;
import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.alert.PriceVolumeAlert;
import dev.pagefault.eve.dirtd.task.DirtTask;

public class AlertTest {

	private static Logger log = LogManager.getLogger();

	public void run() {
		try {
			DbPool dbPool = new DbPool(new DbInfo());
			dbPool.setMinPoolSize(2);
			Connection db = dbPool.acquire();
			for (Alert a : AlertTable.getAllAlerts(db)) {
				log.debug("running alert " + a.getAlertId());
				DirtTask t = new PriceVolumeAlert(a);
				t.setDbPool(dbPool);
				t.run();
			}
		} catch (SQLException e) {
			log.fatal(e);
		}
	}

	public static void main(String[] args) {
		Configurator.setRootLevel(Level.DEBUG);
		new AlertTest().run();
	}

}
