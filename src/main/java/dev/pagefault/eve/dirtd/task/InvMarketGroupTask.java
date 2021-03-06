package dev.pagefault.eve.dirtd.task;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.MarketGroupTable;
import dev.pagefault.eve.dirtd.TypeUtil;
import dev.pagefault.eve.dirtd.esi.MarketApiWrapper;
import net.evetech.ApiException;
import net.evetech.esi.models.GetMarketsGroupsMarketGroupIdOk;

public class InvMarketGroupTask extends DirtTask {

	private static Logger log = LogManager.getLogger();

	private int marketGroupId;

	public InvMarketGroupTask(int marketGroupId) {
		this.marketGroupId = marketGroupId;
	}

	@Override
	public String getTaskName() {
		return "market-group-" + marketGroupId;
	}

	@Override
	protected void runTask() {
		MarketApiWrapper mapiw = new MarketApiWrapper(getDb());

		GetMarketsGroupsMarketGroupIdOk group;
		try {
			group = mapiw.getMarketGroup(marketGroupId);
		} catch (ApiException e) {
			if (e.getCode() != 304) {
				log.fatal("Failed to query market group info for marketGroupId " + marketGroupId + ": " + e.getLocalizedMessage());
				log.debug(e);
			}
			return;
		}
		try {
			MarketGroupTable.upsert(getDb(), TypeUtil.convert(group));
		} catch (SQLException e) {
			log.fatal("Failed to upsert market group info for marketGroupId " + marketGroupId + ": " + e.getLocalizedMessage());
			log.debug(e);
		}
	}

}
