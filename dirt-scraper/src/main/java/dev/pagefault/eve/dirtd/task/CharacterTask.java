package dev.pagefault.eve.dirtd.task;

import java.sql.Date;
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

	private static final Logger log = LogManager.getLogger();

	private static final int SLEEP_HACK = 1000;

	private final int charId;

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
			log.debug("Inserted information for character " + charId);
		} catch (ApiException e) {
			if (e.getCode() == 404) {
				// character was deleted
				// insert a special entry so that we don't constantly retry and 420 ourselves
				Character c = new Character();
				c.setCharId(charId);
				c.setAllianceId(0);
				c.setCorpId(1000001);
				c.setCharName("DELETED-" + charId);
				c.setBirthday(new Date(0));
				try {
					CharacterTable.upsert(getDb(), c);
					log.info("Inserted null character for deleted character " + charId);
				} catch (SQLException ex) {
					log.error("Failed to insert info for character " + charId + ": " + e.getLocalizedMessage());
					log.debug(e);
				}
			} else {
				log.error("Failed to retrieve info for character " + charId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
		} catch (SQLException e) {
			log.error("Failed to insert info for character " + charId + ": " + e.getLocalizedMessage());
			log.debug(e);
		}
		try {
			Thread.sleep(SLEEP_HACK);
		} catch (InterruptedException ignored) {
		}
	}

}
