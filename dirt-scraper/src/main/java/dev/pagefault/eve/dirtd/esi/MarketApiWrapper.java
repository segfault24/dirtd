package dev.pagefault.eve.dirtd.esi;

import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.util.Utils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.MarketApi;
import net.evetech.esi.models.GetCharactersCharacterIdOrders200Ok;
import net.evetech.esi.models.GetMarketsGroupsMarketGroupIdOk;
import net.evetech.esi.models.GetMarketsRegionIdHistory200Ok;
import net.evetech.esi.models.GetMarketsRegionIdOrders200Ok;
import net.evetech.esi.models.GetMarketsStructuresStructureId200Ok;

public class MarketApiWrapper {

	private static Logger log = LogManager.getLogger();

	private static final int MAX_ATTEMPTS = 3;
	private static final int RETRY_WAIT = 5000; // milliseconds

	private Connection db;
	private MarketApi mapi;

	public MarketApiWrapper(Connection db) {
		this.db = db;
		mapi = new MarketApi();
	}

	public ApiResponse<List<GetMarketsRegionIdOrders200Ok>> getMarketsRegionIdOrders(int regionId, int page) throws ApiException {
		EsiUtils.precall();
		log.trace("Executing API query getMarketsRegionIdOrders(" + regionId + ", " + page + ")");
		ApiResponse<List<GetMarketsRegionIdOrders200Ok>> resp = null;
		boolean done = false;
		int attempt = 1;
		while (!done && attempt <= MAX_ATTEMPTS) {
			try {
				EsiUtils.esiCalls++;
				resp = mapi.getMarketsRegionIdOrdersWithHttpInfo("all", regionId, Utils.getApiDatasource(), null, page, null);
				done = true;
			} catch (ApiException e) {
				EsiUtils.esiErrors++;
				if (attempt == MAX_ATTEMPTS) {
					// throw after reaching MAX_ATTEMPTS
					throw e;
				} else if (e.getCode() < 500 && !(e.getCause() instanceof SocketTimeoutException)) {
					// immediately throw non-500 errors (probably our fault)
					throw e;
				} else {
					// sleep with linear backoff and then retry
					log.warn("Retrying API query getMarketsRegionIdOrders(" + regionId + ", " + page + ")");
					Utils.sleep(RETRY_WAIT * attempt);
				}
			}
			attempt++;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		EsiUtils.postcall(resp);
		return resp;
	}

	public List<GetMarketsRegionIdHistory200Ok> getMarketsRegionIdHistory(int regionId, int typeId)
			throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "history-" + regionId + "-" + typeId);
		log.trace("Executing API query getMarketsRegionIdHistory(" + regionId + ", " + typeId + ")");
		ApiResponse<List<GetMarketsRegionIdHistory200Ok>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = mapi.getMarketsRegionIdHistoryWithHttpInfo(regionId, typeId, Utils.getApiDatasource(), etag);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		if (!resp.getData().isEmpty()) {
			Utils.upsertEtag(db, "history-" + regionId + "-" + typeId, Utils.getEtag(resp.getHeaders()));
		}
		EsiUtils.postcall(resp);
		return resp.getData();
	}

	public ApiResponse<List<GetMarketsStructuresStructureId200Ok>> getMarketsStructureIdOrders(long structId, int page, String token) throws ApiException {
		EsiUtils.precall();
		log.trace("Executing API query getMarketsStructureStructureId(" + structId + ", " + page + ")");
		ApiResponse<List<GetMarketsStructuresStructureId200Ok>> resp = null;
		boolean done = false;
		int attempt = 1;
		while (!done && attempt <= MAX_ATTEMPTS) {
			try {
				EsiUtils.esiCalls++;
				resp = mapi.getMarketsStructuresStructureIdWithHttpInfo(structId, Utils.getApiDatasource(), null, page, token);
				done = true;
			} catch (ApiException e) {
				EsiUtils.esiErrors++;
				if (attempt == MAX_ATTEMPTS) {
					// throw after reaching MAX_ATTEMPTS
					throw e;
				} else if (e.getCode() < 500 && !(e.getCause() instanceof SocketTimeoutException)) {
					// immediately throw non-500 errors (probably our fault)
					throw e;
				} else {
					// sleep with linear backoff and then retry
					log.warn("Retrying API query getMarketsStructuresStructureId(" + structId + ", " + page + ")");
					Utils.sleep(RETRY_WAIT * attempt);
				}
			}
			attempt++;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		EsiUtils.postcall(resp);
		return resp;
	}
	
	public List<GetCharactersCharacterIdOrders200Ok> getMarketsCharacterIdOrders(int charId, String token) throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "character-orders-" + charId);
		log.trace("Executing API query getCharactersCharacterIdOrders(" + charId + ")");
		ApiResponse<List<GetCharactersCharacterIdOrders200Ok>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = mapi.getCharactersCharacterIdOrdersWithHttpInfo(charId, Utils.getApiDatasource(), etag, token);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		if (!resp.getData().isEmpty()) {
			Utils.upsertEtag(db, "character-orders-" + charId, Utils.getEtag(resp.getHeaders()));
		}
		EsiUtils.postcall(resp);
		return resp.getData();
	}

	public List<Integer> getMarketGroupIds() throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "market-groups");
		log.trace("Executing API query getMarketGroupIds()");
		ApiResponse<List<Integer>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = mapi.getMarketsGroupsWithHttpInfo(Utils.getApiDatasource(), etag);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		Utils.upsertEtag(db, "market-groups", Utils.getEtag(resp.getHeaders()));
		EsiUtils.postcall(resp);
		return resp.getData();
	}

	public GetMarketsGroupsMarketGroupIdOk getMarketGroup(int marketGroupId) throws ApiException {
		EsiUtils.precall();
		String etag = Utils.getEtag(db, "market-group-" + marketGroupId);
		log.trace("Executing API query getMarketGroup(" + marketGroupId + ")");
		ApiResponse<GetMarketsGroupsMarketGroupIdOk> resp;
		try {
			EsiUtils.esiCalls++;
			resp = mapi.getMarketsGroupsMarketGroupIdWithHttpInfo(marketGroupId, Utils.getApiLanguage(), Utils.getApiDatasource(), etag, Utils.getApiLanguage());
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		Utils.upsertEtag(db, "market-group-" + marketGroupId, Utils.getEtag(resp.getHeaders()));
		EsiUtils.postcall(resp);
		return resp.getData();
	}

}
