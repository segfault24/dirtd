package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.CharacterTable;
import dev.pagefault.eve.dbtools.model.Character;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.CharacterApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetCharactersCharacterIdOk;

/**
 * Task to retrieve information about a character.
 * 
 * @author austin
 */
public class CharacterTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private int charId;

	public CharacterTask(int charId) {
		this.charId = charId;
	}

	@Override
	public String getTaskName() {
		return "character-" + charId;
	}

	@Override
	public void runTask() {
		CharacterApiWrapper capiw = new CharacterApiWrapper(getDb());
		log.debug("Querying character information for character " + charId);

		try {
			GetCharactersCharacterIdOk info = capiw.getCharacter(charId);
			Character c = TypeUtil.convert(info);
			c.setCharId(charId);
			CharacterTable.upsert(getDb(), c);
		} catch (ApiException e) {
			log.error("Failed to retrieve info for character " + charId + ": " + e.getLocalizedMessage());
			log.debug(e);
		} catch (SQLException e) {
			log.error("Failed to insert info for character " + charId + ": " + e.getLocalizedMessage());
			log.debug(e);
		}
		log.debug("Inserted information for character " + charId);
	}

}
