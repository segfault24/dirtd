package dev.pagefault.eve.dirtd.task;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dirtd.esi.UniverseApiWrapper;
import net.evetech.ApiException;

/**
 * Task to retrieve/update region info
 * 
 * @author austin
 */
public class MapDataTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	@Override
	public String getTaskName() {
		return "mapdata";
	}

	@Override
	protected void runTask() {
		UniverseApiWrapper uapiw = new UniverseApiWrapper(getDb());
		
		List<Integer> regions;
		try {
			regions = uapiw.getUniverseRegions();
		} catch (ApiException e) {
			if (e.getCode() != 304) {
				log.fatal("Failed to query for region ids: " + e.getLocalizedMessage());
				log.debug(e);
			}
			return;
		}
		for (Integer region : regions) {
			getExecutor().scheduleTask(new RegionTask(region));;
		}
	}

}
