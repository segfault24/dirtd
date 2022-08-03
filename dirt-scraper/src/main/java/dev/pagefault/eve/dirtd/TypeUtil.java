package dev.pagefault.eve.dirtd;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dev.pagefault.eve.dbtools.model.Character;
import dev.pagefault.eve.dbtools.model.CharOrder;
import dev.pagefault.eve.dbtools.model.Constellation;
import dev.pagefault.eve.dbtools.model.Contract;
import dev.pagefault.eve.dbtools.model.Contract.ContractAvailability;
import dev.pagefault.eve.dbtools.model.Contract.ContractStatus;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;
import dev.pagefault.eve.dbtools.model.ContractItem;
import dev.pagefault.eve.dbtools.model.Corporation;
import dev.pagefault.eve.dbtools.model.InsurancePrice;
import dev.pagefault.eve.dbtools.model.InvType;
import dev.pagefault.eve.dbtools.model.MarketGroup;
import dev.pagefault.eve.dbtools.model.MarketHistoryEntry;
import dev.pagefault.eve.dbtools.model.MarketOrder;
import dev.pagefault.eve.dbtools.model.PublicContract;
import dev.pagefault.eve.dbtools.model.PublicContractItem;
import dev.pagefault.eve.dbtools.model.Region;
import dev.pagefault.eve.dbtools.model.SolarSystem;
import dev.pagefault.eve.dbtools.model.Station;
import dev.pagefault.eve.dbtools.model.Structure;
import dev.pagefault.eve.dbtools.model.WalletJournalEntry;
import dev.pagefault.eve.dbtools.model.WalletTransaction;
import net.evetech.esi.models.GetCharactersCharacterIdContracts200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdContractsContractIdItems200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdOk;
import net.evetech.esi.models.GetCharactersCharacterIdOrders200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdWalletJournal200Ok;
import net.evetech.esi.models.GetCharactersCharacterIdWalletTransactions200Ok;
import net.evetech.esi.models.GetContractsPublicItemsContractId200Ok;
import net.evetech.esi.models.GetContractsPublicRegionId200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdContracts200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdContractsContractIdItems200Ok;
import net.evetech.esi.models.GetCorporationsCorporationIdOk;
import net.evetech.esi.models.GetInsurancePrices200Ok;
import net.evetech.esi.models.GetInsurancePricesLevel;
import net.evetech.esi.models.GetMarketsGroupsMarketGroupIdOk;
import net.evetech.esi.models.GetMarketsRegionIdHistory200Ok;
import net.evetech.esi.models.GetMarketsRegionIdOrders200Ok;
import net.evetech.esi.models.GetMarketsStructuresStructureId200Ok;
import net.evetech.esi.models.GetUniverseConstellationsConstellationIdOk;
import net.evetech.esi.models.GetUniverseRegionsRegionIdOk;
import net.evetech.esi.models.GetUniverseStationsStationIdOk;
import net.evetech.esi.models.GetUniverseStructuresStructureIdOk;
import net.evetech.esi.models.GetUniverseSystemsSystemIdOk;
import net.evetech.esi.models.GetUniverseTypesTypeIdOk;
import org.threeten.bp.ZoneOffset;

/**
 * Utilities for converting ESI types to our types
 *
 * @author austin
 */
public interface TypeUtil {

	public static ContractStatus convertContractStatus(String s) {
		switch (s) {
		case "outstanding":
			return ContractStatus.OUTSTANDING;
		case "in_progress":
			return ContractStatus.IN_PROGRESS;
		case "finished_issuer":
			return ContractStatus.FINISHED_ISSUER;
		case "finished_contractor":
			return ContractStatus.FINISHED_CONTRACTOR;
		case "finished":
			return ContractStatus.FINISHED;
		case "cancelled":
			return ContractStatus.CANCELLED;
		case "rejected":
			return ContractStatus.REJECTED;
		case "failed":
			return ContractStatus.FAILED;
		case "deleted":
			return ContractStatus.DELETED;
		case "reversed":
			return ContractStatus.REVERSED;
		default:
			return ContractStatus.UNKNOWN;
		}
	}

	public static ContractType convertContractType(String t) {
		switch (t) {
		case "item_exchange":
			return ContractType.ITEM_EXCHANGE;
		case "auction":
			return ContractType.AUCTION;
		case "courier":
			return ContractType.COURIER;
		case "loan":
			return ContractType.LOAN;
		case "unknown":
		default:
			return ContractType.UNKNOWN;
		}
	}

	public static ContractAvailability convertContractAvailability(String a) {
		switch (a) {
		case "public":
			return ContractAvailability.PUBLIC;
		case "personal":
			return ContractAvailability.PERSONAL;
		case "corporation":
			return ContractAvailability.CORPORATION;
		case "alliance":
			return ContractAvailability.ALLIANCE;
		default:
			return ContractAvailability.UNKNOWN;
		}
	}

	public static Contract convert(GetCharactersCharacterIdContracts200Ok c) {
		Contract contract = new Contract();
		if (c.getContractId() != null)
			contract.setContractId(c.getContractId());
		if (c.getIssuerId() != null)
			contract.setIssuerId(c.getIssuerId());
		if (c.getIssuerCorporationId() != null)
			contract.setIssuerCorpId(c.getIssuerCorporationId());
		if (c.getAssigneeId() != null)
			contract.setAssigneeId(c.getAssigneeId());
		if (c.getAcceptorId() != null)
			contract.setAcceptorId(c.getAcceptorId());
		if (c.getAvailability() != null)
			contract.setAvailability(convertContractAvailability(c.getAvailability().toString()));
		if (c.getStatus() != null)
			contract.setStatus(convertContractStatus(c.getStatus().toString()));
		if (c.getType() != null)
			contract.setType(convertContractType(c.getType().toString()));
		if (c.getDateIssued() != null)
			contract.setDateIssued(new Timestamp(c.getDateIssued().toInstant().toEpochMilli()));
		if (c.getDateExpired() != null)
			contract.setDateExpired(new Timestamp(c.getDateExpired().toInstant().toEpochMilli()));
		if (c.getDateAccepted() != null)
			contract.setDateAccepted(new Timestamp(c.getDateAccepted().toInstant().toEpochMilli()));
		if (c.getDateCompleted() != null)
			contract.setDateCompleted(new Timestamp(c.getDateCompleted().toInstant().toEpochMilli()));
		if (c.getTitle() != null)
			contract.setTitle(c.getTitle());
		if (c.isForCorporation() != null)
			contract.setForCorp(c.isForCorporation());
		if (c.getStartLocationId() != null)
			contract.setStartLocationId(c.getStartLocationId());
		if (c.getEndLocationId() != null)
			contract.setEndLocationId(c.getEndLocationId());
		if (c.getDaysToComplete() != null)
			contract.setDaysToComplete(c.getDaysToComplete());
		if (c.getPrice() != null)
			contract.setPrice(c.getPrice());
		if (c.getReward() != null)
			contract.setReward(c.getReward());
		if (c.getCollateral() != null)
			contract.setCollateral(c.getCollateral());
		if (c.getBuyout() != null)
			contract.setBuyout(c.getBuyout());
		if (c.getVolume() != null)
			contract.setVolume(c.getVolume());
		return contract;
	}

	public static ContractItem convert(GetCharactersCharacterIdContractsContractIdItems200Ok i) {
		ContractItem item = new ContractItem();
		item.setTypeId(i.getTypeId());
		item.setQuantity(i.getQuantity());
		item.setRecordId(i.getRecordId());
		item.setIncluded(i.isIsIncluded());
		item.setSingleton(i.isIsSingleton());
		return item;
	}

	public static Contract convert(GetCorporationsCorporationIdContracts200Ok c) {
		Contract contract = new Contract();
		if (c.getContractId() != null)
			contract.setContractId(c.getContractId());
		if (c.getIssuerId() != null)
			contract.setIssuerId(c.getIssuerId());
		if (c.getIssuerCorporationId() != null)
			contract.setIssuerCorpId(c.getIssuerCorporationId());
		if (c.getAssigneeId() != null)
			contract.setAssigneeId(c.getAssigneeId());
		if (c.getAcceptorId() != null)
			contract.setAcceptorId(c.getAcceptorId());
		if (c.getAvailability() != null)
			contract.setAvailability(convertContractAvailability(c.getAvailability().toString()));
		if (c.getStatus() != null)
			contract.setStatus(convertContractStatus(c.getStatus().toString()));
		if (c.getType() != null)
			contract.setType(convertContractType(c.getType().toString()));
		if (c.getDateIssued() != null)
			contract.setDateIssued(new Timestamp(c.getDateIssued().toInstant().toEpochMilli()));
		if (c.getDateExpired() != null)
			contract.setDateExpired(new Timestamp(c.getDateExpired().toInstant().toEpochMilli()));
		if (c.getDateAccepted() != null)
			contract.setDateAccepted(new Timestamp(c.getDateAccepted().toInstant().toEpochMilli()));
		if (c.getDateCompleted() != null)
			contract.setDateCompleted(new Timestamp(c.getDateCompleted().toInstant().toEpochMilli()));
		if (c.getTitle() != null)
			contract.setTitle(c.getTitle());
		if (c.isForCorporation() != null)
			contract.setForCorp(c.isForCorporation());
		if (c.getStartLocationId() != null)
			contract.setStartLocationId(c.getStartLocationId());
		if (c.getEndLocationId() != null)
			contract.setEndLocationId(c.getEndLocationId());
		if (c.getDaysToComplete() != null)
			contract.setDaysToComplete(c.getDaysToComplete());
		if (c.getPrice() != null)
			contract.setPrice(c.getPrice());
		if (c.getReward() != null)
			contract.setReward(c.getReward());
		if (c.getCollateral() != null)
			contract.setCollateral(c.getCollateral());
		if (c.getBuyout() != null)
			contract.setBuyout(c.getBuyout());
		if (c.getVolume() != null)
			contract.setVolume(c.getVolume());
		return contract;
	}

	public static ContractItem convert(GetCorporationsCorporationIdContractsContractIdItems200Ok i) {
		ContractItem item = new ContractItem();
		item.setTypeId(i.getTypeId());
		item.setQuantity(i.getQuantity());
		item.setRecordId(i.getRecordId());
		item.setIncluded(i.isIsIncluded());
		item.setSingleton(i.isIsSingleton());
		return item;
	}

	public static PublicContract convert(GetContractsPublicRegionId200Ok c) {
		PublicContract contract = new PublicContract();
		if (c.getContractId() != null)
			contract.setContractId(c.getContractId());
		if (c.getIssuerId() != null)
			contract.setIssuerId(c.getIssuerId());
		if (c.getIssuerCorporationId() != null)
			contract.setIssuerCorpId(c.getIssuerCorporationId());
		if (c.getType() != null)
			contract.setType(convertContractType(c.getType().toString()));
		if (c.getDateIssued() != null)
			contract.setDateIssued(new Timestamp(c.getDateIssued().toInstant().toEpochMilli()));
		if (c.getDateExpired() != null)
			contract.setDateExpired(new Timestamp(c.getDateExpired().toInstant().toEpochMilli()));
		if (c.getTitle() != null)
			contract.setTitle(c.getTitle());
		if (c.isForCorporation() != null)
			contract.setForCorp(c.isForCorporation());
		if (c.getStartLocationId() != null)
			contract.setStartLocationId(c.getStartLocationId());
		if (c.getEndLocationId() != null)
			contract.setEndLocationId(c.getEndLocationId());
		if (c.getDaysToComplete() != null)
			contract.setDaysToComplete(c.getDaysToComplete());
		if (c.getPrice() != null)
			contract.setPrice(c.getPrice());
		if (c.getReward() != null)
			contract.setReward(c.getReward());
		if (c.getCollateral() != null)
			contract.setCollateral(c.getCollateral());
		if (c.getBuyout() != null)
			contract.setBuyout(c.getBuyout());
		if (c.getVolume() != null)
			contract.setVolume(c.getVolume());
		return contract;
	}

	public static PublicContractItem convert(GetContractsPublicItemsContractId200Ok i) {
		PublicContractItem item = new PublicContractItem();
		if (i.getTypeId() != null)
			item.setTypeId(i.getTypeId());
		if (i.getQuantity() != null)
			item.setQuantity(i.getQuantity());
		if (i.getRecordId() != null)
			item.setRecordId(i.getRecordId());
		if (i.isIsIncluded() != null)
			item.setIncluded(i.isIsIncluded());
		if (i.isIsBlueprintCopy() != null)
			item.setBpc(i.isIsBlueprintCopy());
		if (i.getItemId() != null)
			item.setItemId(i.getItemId());
		if (i.getMaterialEfficiency() != null)
			item.setMaterialEfficiency(i.getMaterialEfficiency().shortValue());
		if (i.getTimeEfficiency() != null)
			item.setTimeEfficiency(i.getTimeEfficiency().shortValue());
		if (i.getRuns() != null)
			item.setRuns(i.getRuns());
		return item;
	}

	public static InvType convert(GetUniverseTypesTypeIdOk t) {
		InvType type = new InvType();
		if (t.getTypeId() != null)
			type.setTypeId(t.getTypeId());
		if (t.getGroupId() != null)
			type.setGroupId(t.getGroupId());
		if (t.getName() != null)
			type.setTypeName(t.getName());
		if (t.getDescription() != null)
			type.setDescription(t.getDescription());
		if (t.getMass() != null)
			type.setMass(t.getMass());
		if (t.getVolume() != null)
			type.setVolume(t.getVolume());
		if (t.isPublished() != null)
			type.setPublished(t.isPublished());
		if (t.getMarketGroupId() != null)
			type.setMarketGroupId(t.getMarketGroupId());
		return type;
	}

	public static MarketGroup convert(GetMarketsGroupsMarketGroupIdOk g) {
		MarketGroup group = new MarketGroup();
		group.setMarketGroupId(g.getMarketGroupId());
		if (g.getParentGroupId() != null)
			group.setParentGroupId(g.getParentGroupId());
		group.setMarketGroupName(g.getName());
		group.setDescription(g.getDescription());
		group.setHasTypes(!g.getTypes().isEmpty());
		return group;
	}

	public static Character convert(GetCharactersCharacterIdOk c) {
		Character character = new Character();
		character.setCharName(c.getName());
		character.setCorpId(c.getCorporationId());
		if (c.getAllianceId() != null)
			character.setAllianceId(c.getAllianceId());
		character.setBirthday(new Date(c.getBirthday().toInstant().toEpochMilli()));
		return character;
	}

	public static Corporation convert(GetCorporationsCorporationIdOk c) {
		Corporation corp = new Corporation();
		corp.setCorpName(c.getName());
		corp.setTicker(c.getTicker());
		if (c.getAllianceId() != null)
			corp.setAllianceId(c.getAllianceId());
		corp.setCeoId(c.getCeoId());
		corp.setCreatorId(c.getCreatorId());
		if (c.getDateFounded() != null)
			corp.setCreationDate(new Date(c.getDateFounded().toInstant().toEpochMilli()));
		corp.setMemberCount(c.getMemberCount());
		corp.setTaxRate(c.getTaxRate());
		corp.setUrl(c.getUrl());
		return corp;
	}

	public static Structure convert(GetUniverseStructuresStructureIdOk s) {
		Structure struct = new Structure();
		struct.setStructName(s.getName());
		struct.setCorpId(s.getOwnerId());
		struct.setSystemId(s.getSolarSystemId());
		struct.setTypeId(s.getTypeId());
		return struct;
	}

	public static MarketOrder convert(GetMarketsRegionIdOrders200Ok o) {
		MarketOrder order = new MarketOrder();
		order.setIssued(new Timestamp(o.getIssued().toInstant().toEpochMilli()));
		order.setRange(convert(o.getRange()));
		order.setBuyOrder(o.isIsBuyOrder());
		order.setDuration(o.getDuration().shortValue());
		order.setOrderId(o.getOrderId());
		order.setVolumeRemain(o.getVolumeRemain());
		order.setMinVolume(o.getMinVolume());
		order.setTypeId(o.getTypeId());
		order.setVolumeTotal(o.getVolumeTotal());
		order.setLocationId(o.getLocationId());
		order.setPrice(o.getPrice());
		return order;
	}

	public static MarketOrder convert(GetMarketsStructuresStructureId200Ok o) {
		MarketOrder order = new MarketOrder();
		order.setIssued(new Timestamp(o.getIssued().toInstant().toEpochMilli()));
		order.setRange(convert(o.getRange()));
		order.setBuyOrder(o.isIsBuyOrder());
		order.setDuration(o.getDuration().shortValue());
		order.setOrderId(o.getOrderId());
		order.setVolumeRemain(o.getVolumeRemain());
		order.setMinVolume(o.getMinVolume());
		order.setTypeId(o.getTypeId());
		order.setVolumeTotal(o.getVolumeTotal());
		order.setLocationId(o.getLocationId());
		order.setPrice(o.getPrice());
		return order;
	}

	public static CharOrder convert(GetCharactersCharacterIdOrders200Ok o) {
		CharOrder order = new CharOrder();
		if (o.getIssued() != null)
			order.setIssued(new Timestamp(o.getIssued().toInstant().toEpochMilli()));
		if (o.getRange() != null)
			order.setRange(o.getRange().toString());
		if (o.isIsBuyOrder() != null)
			order.setBuyOrder(o.isIsBuyOrder());
		if (o.getDuration() != null)
			order.setDuration(o.getDuration());
		if (o.getOrderId() != null)
			order.setOrderId(o.getOrderId());
		if (o.getVolumeRemain() != null)
			order.setVolumeRemain(o.getVolumeRemain());
		if (o.getMinVolume() != null)
			order.setMinVolume(o.getMinVolume());
		if (o.getTypeId() != null)
			order.setTypeId(o.getTypeId());
		if (o.getVolumeTotal() != null)
			order.setVolumeTotal(o.getVolumeTotal());
		if (o.getLocationId() != null)
			order.setLocationId(o.getLocationId());
		if (o.getPrice() != null)
			order.setPrice(o.getPrice());
		if (o.getRegionId() != null)
			order.setRegion(o.getRegionId());
		return order;
	}

	public static MarketHistoryEntry convert(GetMarketsRegionIdHistory200Ok h) {
		MarketHistoryEntry entry = new MarketHistoryEntry();
		entry.setDate(Date.valueOf(h.getDate().toString()));
		entry.setHighest(h.getHighest());
		entry.setAverage(h.getAverage());
		entry.setLowest(h.getLowest());
		entry.setOrderCount(h.getOrderCount());
		entry.setVolume(h.getVolume());
		return entry;
	}

	public static WalletTransaction convert(GetCharactersCharacterIdWalletTransactions200Ok t) {
		WalletTransaction transaction = new WalletTransaction();
		transaction.setTransactionId(t.getTransactionId());
		transaction.setClientId(t.getClientId());
		transaction.setDate(new Timestamp(t.getDate().toInstant().toEpochMilli()));
		transaction.setBuy(t.isIsBuy());
		transaction.setPersonal(t.isIsPersonal());
		transaction.setTypeId(t.getTypeId());
		transaction.setQuantity(t.getQuantity());
		transaction.setUnitPrice(t.getUnitPrice());
		transaction.setLocationId(t.getLocationId());
		transaction.setJournalRefId(t.getJournalRefId());
		return transaction;
	}

	public static WalletJournalEntry convert(GetCharactersCharacterIdWalletJournal200Ok j) {
		WalletJournalEntry entry = new WalletJournalEntry();
		entry.setJournalId(j.getId());
		entry.setDate(new Timestamp(j.getDate().toInstant().toEpochMilli()));
		entry.setAmount(j.getAmount());
		entry.setBalance(j.getBalance());
		if (j.getTax() != null)
			entry.setTax(j.getTax());
		if (j.getFirstPartyId() != null)
			entry.setFirstPartyId(j.getFirstPartyId());
		if (j.getSecondPartyId() != null)
			entry.setSecondPartyId(j.getSecondPartyId());
		if (j.getTaxReceiverId() != null)
			entry.setTaxReceiverId(j.getTaxReceiverId());
		if (j.getDescription() != null)
			entry.setDescription(j.getDescription());
		if (j.getReason() != null)
			entry.setReason(j.getReason());
		if (j.getRefType() != null)
			entry.setRefType(j.getRefType().toString());
		if (j.getContextId() != null)
			entry.setContextId(j.getContextId());
		if (j.getContextIdType() != null)
			entry.setContextIdType(j.getContextIdType().toString());
		return entry;
	}

	public static InsurancePrice convert(GetInsurancePrices200Ok p) {
		InsurancePrice price = new InsurancePrice();
		price.setTypeId(p.getTypeId());
		List<InsurancePrice.Level> levels = new ArrayList<InsurancePrice.Level>();
		for (GetInsurancePricesLevel l : p.getLevels()) {
			InsurancePrice.Level level = new InsurancePrice.Level();
			level.setName(l.getName());
			level.setCost(l.getCost());
			level.setPayout(l.getPayout());
			levels.add(level);
		}
		price.setLevels(levels);
		return price;
	}

	public static Region convert(GetUniverseRegionsRegionIdOk r) {
		Region region = new Region();
		region.setReigonId(r.getRegionId());
		region.setRegionName(r.getName());
		region.setDescription(r.getDescription());
		return region;
	}

	public static Constellation convert(GetUniverseConstellationsConstellationIdOk c) {
		Constellation constellation = new Constellation();
		constellation.setConstellationId(c.getConstellationId());
		constellation.setConstellationName(c.getName());
		constellation.setRegionId(c.getRegionId());
		return constellation;
	}

	public static SolarSystem convert(GetUniverseSystemsSystemIdOk s) {
		SolarSystem system = new SolarSystem();
		system.setSolarSystemId(s.getSystemId());
		system.setSolarSystemName(s.getName());
		system.setConstellationId(s.getConstellationId());
		system.setX(s.getPosition().getX());
		system.setY(s.getPosition().getY());
		system.setZ(s.getPosition().getZ());
		system.setSecurity(s.getSecurityStatus());
		return system;
	}

	public static Station convert(GetUniverseStationsStationIdOk s) {
		Station station = new Station();
		station.setStationId(s.getStationId());
		station.setStationName(s.getName());
		station.setSolarSystemId(s.getSystemId());
		return station;
	}

	public static int convert(GetMarketsRegionIdOrders200Ok.RangeEnum range) {
		switch(range) {
			case STATION: return 0;
			case REGION: return 100;
			case SOLARSYSTEM: return 1;
			case _1: return 1;
			case _2: return 2;
			case _3: return 3;
			case _4: return 4;
			case _5: return 5;
			case _10: return 10;
			case _20: return 20;
			case _30: return 30;
			case _40: return 40;
			default: return 0;
		}
	}

	public static int convert(GetMarketsStructuresStructureId200Ok.RangeEnum range) {
		switch(range) {
			case STATION: return 0;
			case REGION: return 100;
			case SOLARSYSTEM: return 1;
			case _1: return 1;
			case _2: return 2;
			case _3: return 3;
			case _4: return 4;
			case _5: return 5;
			case _10: return 10;
			case _20: return 20;
			case _30: return 30;
			case _40: return 40;
			default: return 0;
		}
	}
}
