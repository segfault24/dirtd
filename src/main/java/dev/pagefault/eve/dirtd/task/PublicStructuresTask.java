package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.ApiAuthTable;
import dev.pagefault.eve.dbtools.db.MapTables;
import dev.pagefault.eve.dbtools.db.StructureTable;
import dev.pagefault.eve.dbtools.model.OAuthUser;
import dev.pagefault.eve.dbtools.model.Structure;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.UniverseApiWrapper;
import dev.pagefault.eve.dirtd.esi.auth.OAuthUtil;
import net.evetech.ApiException;
import net.evetech.esi.models.GetUniverseStructuresStructureIdOk;

/**
 * Task to retrieve all public structures.
 * 
 * @author austin
 */
public class PublicStructuresTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	public PublicStructuresTask() {
	}

	@Override
	public String getTaskName() {
		return "public-structures";
	}

	@Override
	public void runTask() {
		UniverseApiWrapper uapiw = new UniverseApiWrapper(getDb());

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

		List<Long> structIds = new ArrayList<Long>();
		try {
			structIds = uapiw.getUniverseStructures();
		} catch (ApiException e) {
			if (e.getCode() != 304) {
				log.fatal("Failed to retrieve list of public structure ids: " + e.getLocalizedMessage());
				log.debug(e);
			}
			return;
		}
		log.debug("Retrieved " + structIds.size() + " public structure ids");

		for (Long structId : structIds) {
			try {
				GetUniverseStructuresStructureIdOk info = uapiw.getUniverseStructuresStructureId(structId, OAuthUtil.getAuthToken(getDb(), auth));
				Structure s = TypeUtil.convert(info);
				s.setStructId(structId);
				s.setRegionId(MapTables.findRegionBySystem(getDb(), s.getSystemId()).getReigonId());
				StructureTable.insert(getDb(), s);
				log.debug("Inserted structure information for structId=" + structId);
			} catch (ApiException e) {
				if (e.getCode() != 304) {
					log.error("Failed to retrieve info for structure " + structId + ": " + e.getLocalizedMessage());
					log.debug(e);
				}
			} catch (SQLException e) {
				log.error("Failed to insert info for structure " + structId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
		}
	}

}
