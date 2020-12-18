package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.MapTables;
import dev.pagefault.eve.dbtools.model.Constellation;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.UniverseApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetUniverseConstellationsConstellationIdOk;

public class ConstellationTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private int constellationId;

	public ConstellationTask(int constellationId) {
		this.constellationId = constellationId;
	}

	@Override
	public String getTaskName() {
		return "constellation-" + constellationId;
	}

	@Override
	protected void runTask() {
		UniverseApiWrapper uapiw = new UniverseApiWrapper(getDb());

		GetUniverseConstellationsConstellationIdOk constellation;
		try {
			constellation = uapiw.getUniverseConstellation(constellationId);
		} catch (ApiException e) {
			if (e.getCode() != 304) {
				log.fatal("Failed to query constellation info for constellationId " + constellationId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
			return;
		}

		Constellation c;
		try {
			c = TypeUtil.convert(constellation);
			MapTables.upsert(getDb(), c);
		} catch (SQLException e) {
			log.fatal("Failed to upsert constellation info for constellationId " + constellationId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}

		for (Integer system : constellation.getSystems()) {
			getDaemon().addTask(new SolarSystemTask(system, c.getRegionId()));
		}
	}

}
