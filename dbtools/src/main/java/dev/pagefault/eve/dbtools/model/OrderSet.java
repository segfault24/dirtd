package dev.pagefault.eve.dbtools.model;

import java.sql.Timestamp;

public class OrderSet {

    private int setId;
    private int regionId;
    private Timestamp retrieved;

    public OrderSet() {
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public Timestamp getRetrieved() {
        return retrieved;
    }

    public void setRetrieved(Timestamp retrieved) {
        this.retrieved = retrieved;
    }

}
