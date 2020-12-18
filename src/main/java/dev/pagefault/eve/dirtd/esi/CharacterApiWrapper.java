package dev.pagefault.eve.dirtd.esi;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.Stats;
import net.evetech.ApiException;
import net.evetech.ApiResponse;
import net.evetech.esi.CharacterApi;
import net.evetech.esi.models.GetCharactersCharacterIdOk;

public class CharacterApiWrapper {

	private static Logger log = LogManager.getLogger();

	private Connection db;
	private CharacterApi capi;

	public CharacterApiWrapper(Connection db) {
		this.db = db;
		capi = new CharacterApi();
	}

	public GetCharactersCharacterIdOk getCharacter(int charId) throws ApiException {
		String etag = Utils.getEtag(db, "character-" + charId);
		log.trace("Executing API query getCharacter(" + charId + ")");
		ApiResponse<GetCharactersCharacterIdOk> resp;
		try {
			Stats.esiCalls++;
			resp = capi.getCharactersCharacterIdWithHttpInfo(charId, Utils.getApiDatasource(), etag);
		} catch(ApiException e) {
			Stats.esiErrors++;
			throw e;
		}
		log.trace("API query returned status code " + resp.getStatusCode());
		Utils.upsertEtag(db, "character-" + charId, Utils.getEtag(resp.getHeaders()));
		return resp.getData();
	}

}
