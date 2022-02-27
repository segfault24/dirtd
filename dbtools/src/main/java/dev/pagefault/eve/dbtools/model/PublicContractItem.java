package dev.pagefault.eve.dbtools.model;

public class PublicContractItem {

	private int contractItemId;
	private int contractId;
	private int typeId;
	private int quantity;
	private long recordId;
	private boolean included;
	private boolean isBpc;
	private long itemId;
	private int materialEfficiency;
	private int timeEfficiency;
	private int runs;

	public PublicContractItem() {
	}

	public int getContractItemId() {
		return contractItemId;
	}

	public void setContractItemId(int contractItemId) {
		this.contractItemId = contractItemId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}

	public boolean isBpc() {
		return isBpc;
	}

	public void setBpc(boolean isBpc) {
		this.isBpc = isBpc;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getMaterialEfficiency() {
		return materialEfficiency;
	}

	public void setMaterialEfficiency(int materialEfficiency) {
		this.materialEfficiency = materialEfficiency;
	}

	public int getTimeEfficiency() {
		return timeEfficiency;
	}

	public void setTimeEfficiency(int timeEfficiency) {
		this.timeEfficiency = timeEfficiency;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

}
