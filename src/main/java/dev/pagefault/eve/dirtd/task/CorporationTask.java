package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.CorporationTable;
import dev.pagefault.eve.dbtools.model.Corporation;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.CorporationApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetCorporationsCorporationIdOk;

/**
 * Task to retrieve information about a corporation.
 * 
 * @author austin
 */
public class CorporationTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private static final int SLEEP_HACK = 1000;

	private int corpId;

	public CorporationTask(int corpId) {
		this.corpId = corpId;
	}

	@Override
	public String getTaskName() {
		return "corporation-" + corpId;
	}

	@Override
	public void runTask() {
		CorporationApiWrapper capiw = new CorporationApiWrapper(getDb());
		log.debug("Querying corporation information for corporation " + corpId);
		try {
			GetCorporationsCorporationIdOk info = capiw.getCorporation(corpId);
			Corporation c = TypeUtil.convert(info);
			c.setCorpId(corpId);
			CorporationTable.upsert(getDb(), c);
		} catch (ApiException e) {
			log.error("Failed to retrieve info for corporation " + corpId + ": " + e.getLocalizedMessage());
			log.debug(e);
		} catch (SQLException e) {
			log.error("Failed to insert info for corporation " + corpId + ": " + e.getLocalizedMessage());
			log.debug(e);
		}
		log.debug("Inserted information for corporation " + corpId);
		try {
			Thread.sleep(SLEEP_HACK);
		} catch (InterruptedException e) {
		}
	}

}
