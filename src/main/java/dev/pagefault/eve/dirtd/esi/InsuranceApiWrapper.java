package dev.pagefault.eve.dirtd.esi;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.util.Utils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.InsuranceApi;
import net.evetech.esi.models.GetInsurancePrices200Ok;

public class InsuranceApiWrapper {

	private static Logger log = LogManager.getLogger();

	private Connection db;
	private InsuranceApi iapi;

	public InsuranceApiWrapper(Connection db) {
		this.db = db;
		iapi = new InsuranceApi();
	}

	public List<GetInsurancePrices200Ok> getInsurancePrices() throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "insurance-prices");
		log.trace("Executing API query getInsurancePrices()");
		ApiResponse<List<GetInsurancePrices200Ok>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = iapi.getInsurancePricesWithHttpInfo(Utils.getApiLanguage(), Utils.getApiDatasource(), etag,
					Utils.getApiLanguage());
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		if (!resp.getData().isEmpty()) {
			Utils.upsertEtag(db, "insurance-prices", Utils.getEtag(resp.getHeaders()));
		}
		EsiUtils.postcall(resp);
		return resp.getData();
	}

}
