package dev.pagefault.eve.dirtd.esi;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.util.Utils;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.WalletApi;
import net.evetech.esi.models.GetCharactersCharacterIdWalletJournal200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdWalletTransactions200Ok;

public class WalletApiWrapper {

	private static Logger log = LogManager.getLogger();

	private WalletApi wapi;

	public WalletApiWrapper(Connection db) {
		wapi = new WalletApi();
	}

	public List<GetCharactersCharacterIdWalletTransactions200Ok> getWalletTransactions(int charId, Long beforeTrans,
			String token) throws ApiException {
		EsiUtils.precall();
		log.trace("Executing API query getWalletTransactions()");
		ApiResponse<List<GetCharactersCharacterIdWalletTransactions200Ok>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = wapi.getCharactersCharacterIdWalletTransactionsWithHttpInfo(charId, Utils.getApiDatasource(),
					beforeTrans, null, token);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		EsiUtils.postcall(resp);
		return resp.getData();
	}

	public List<GetCharactersCharacterIdWalletJournal200Ok> getWalletJournal(int charId, int page, String token)
			throws ApiException {
		EsiUtils.precall();
		log.trace("Executing API query getWalletJournal()");
		ApiResponse<List<GetCharactersCharacterIdWalletJournal200Ok>> resp;
		try {
			EsiUtils.esiCalls++;
			resp = wapi.getCharactersCharacterIdWalletJournalWithHttpInfo(charId, Utils.getApiDatasource(), null, page,
					token);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		EsiUtils.postcall(resp);
		return resp.getData();
	}

	public Double getWalletBalance(int charId, String token) throws ApiException {
		EsiUtils.precall();
		log.trace("Executing API query getWalletBalance()");
		ApiResponse<Double> resp;
		try {
			EsiUtils.esiCalls++;
			resp = wapi.getCharactersCharacterIdWalletWithHttpInfo(charId, Utils.getApiDatasource(), null, token);
		} catch (ApiException e) {
			EsiUtils.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		EsiUtils.postcall(resp);
		return resp.getData();
	}

}
