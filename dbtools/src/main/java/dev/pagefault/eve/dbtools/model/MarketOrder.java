package dev.pagefault.eve.dbtools.model;

import java.sql.Timestamp;

public class MarketOrder {

	private int setId;
	private Timestamp issued;
	private int range;
	private boolean buyOrder;
	private short duration;
	private long orderId;
	private int volumeRemain;
	private int minVolume;
	private int typeId;
	private int volumeTotal;
	private long locationId;
	private double price;

	public MarketOrder() {
	}

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public Timestamp getIssued() {
		return issued;
	}

	public void setIssued(Timestamp issued) {
		this.issued = issued;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public boolean isBuyOrder() {
		return buyOrder;
	}

	public void setBuyOrder(boolean buyOrder) {
		this.buyOrder = buyOrder;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getVolumeRemain() {
		return volumeRemain;
	}

	public void setVolumeRemain(int volumeRemain) {
		this.volumeRemain = volumeRemain;
	}

	public int getMinVolume() {
		return minVolume;
	}

	public void setMinVolume(int minVolume) {
		this.minVolume = minVolume;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getVolumeTotal() {
		return volumeTotal;
	}

	public void setVolumeTotal(int volumeTotal) {
		this.volumeTotal = volumeTotal;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
