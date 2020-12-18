package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.MapTables;
import dev.pagefault.eve.dbtools.model.Region;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.UniverseApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetUniverseRegionsRegionIdOk;

public class RegionTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private int regionId;

	public RegionTask(int regionId) {
		this.regionId = regionId;
	}

	@Override
	public String getTaskName() {
		return "region-" + regionId;
	}

	@Override
	protected void runTask() {
		UniverseApiWrapper uapiw = new UniverseApiWrapper(getDb());

		GetUniverseRegionsRegionIdOk region;
		try {
			region = uapiw.getUniverseRegion(regionId);
		} catch (ApiException e) {
			if (e.getCode() != 304) {
				log.fatal("Failed to query region info for regionId " + regionId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
			return;
		}

		Region r;
		try {
			r = TypeUtil.convert(region);
			MapTables.upsert(getDb(), r);
		} catch (SQLException e) {
			log.fatal("Failed to upsert region info for regionId " + regionId + ": " + e.getLocalizedMessage());
			log.debug(e);
			return;
		}

		for (Integer constellation : region.getConstellations()) {
			getDaemon().addTask(new ConstellationTask(constellation));
		}
	}

}
