package dev.pagefault.eve.dirtd.esi;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.util.Utils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.CorporationApi;
import net.evetech.esi.models.GetCorporationsCorporationIdOk;

public class CorporationApiWrapper {

	private static Logger log = LogManager.getLogger();

	private Connection db;
	private CorporationApi capi;

	public CorporationApiWrapper(Connection db) {
		this.db = db;
		capi = new CorporationApi();
	}

	public GetCorporationsCorporationIdOk getCorporation(int corpId) throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "corporation-" + corpId);
		log.trace("Executing API query getCorporation()");
		ApiResponse<GetCorporationsCorporationIdOk> resp;
		try {
			EsiUtils.esiCalls++;
			resp = capi.getCorporationsCorporationIdWithHttpInfo(corpId, Utils.getApiDatasource(), etag);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		Utils.upsertEtag(db, "corporation-" + corpId, Utils.getEtag(resp.getHeaders()));
		EsiUtils.postcall(resp);
		return resp.getData();
	}

}
