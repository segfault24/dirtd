package dev.pagefault.eve.dbtools.model;

import java.sql.Timestamp;

import dev.pagefault.eve.dbtools.model.Contract.ContractStatus;
import dev.pagefault.eve.dbtools.model.Contract.ContractType;

public class PublicContract {

	private int contractId;
	private int issuerId;
	private int issuerCorpId;
	private ContractType type;
	private ContractStatus status;
	private Timestamp dateIssued;
	private Timestamp dateExpired;
	private String title;
	private boolean forCorp;
	private int regionId;
	private long startLocationId;
	private long endLocationId;
	private int daysToComplete;
	private double price;
	private double reward;
	private double collateral;
	private double buyout;
	private double volume;
	private Timestamp lastSeen;

	public PublicContract() {
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(int issuerId) {
		this.issuerId = issuerId;
	}

	public int getIssuerCorpId() {
		return issuerCorpId;
	}

	public void setIssuerCorpId(int issuerCorpId) {
		this.issuerCorpId = issuerCorpId;
	}

	public ContractType getType() {
		return type;
	}

	public void setType(ContractType type) {
		this.type = type;
	}

	public ContractStatus getStatus() {
		return status;
	}

	public void setStatus(ContractStatus status) {
		this.status = status;
	}

	public Timestamp getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Timestamp dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Timestamp getDateExpired() {
		return dateExpired;
	}

	public void setDateExpired(Timestamp dateExpired) {
		this.dateExpired = dateExpired;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isForCorp() {
		return forCorp;
	}

	public void setForCorp(boolean forCorp) {
		this.forCorp = forCorp;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public long getStartLocationId() {
		return startLocationId;
	}

	public void setStartLocationId(long startLocationId) {
		this.startLocationId = startLocationId;
	}

	public long getEndLocationId() {
		return endLocationId;
	}

	public void setEndLocationId(long endLocationId) {
		this.endLocationId = endLocationId;
	}

	public int getDaysToComplete() {
		return daysToComplete;
	}

	public void setDaysToComplete(int daysToComplete) {
		this.daysToComplete = daysToComplete;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public double getCollateral() {
		return collateral;
	}

	public void setCollateral(double collateral) {
		this.collateral = collateral;
	}

	public double getBuyout() {
		return buyout;
	}

	public void setBuyout(double buyout) {
		this.buyout = buyout;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Timestamp getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Timestamp lastSeen) {
		this.lastSeen = lastSeen;
	}

}
