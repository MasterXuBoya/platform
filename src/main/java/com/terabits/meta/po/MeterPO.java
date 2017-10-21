package com.terabits.meta.po;

/**
 * Created by Administrator on 2017/5/23.
 */
public class MeterPO {
    private int id;
    private String meterId;
    private String community;
    private String building;
    private String room;
    private int relativeLocation;
    private String terminalImei;
    private double meterRemain;
    private int meterState;
    private String gmtCreate;
    private String gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }
    
    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getRelativeLocation() {return relativeLocation;}

    public void setRelativeLocation(int relativeLocation) {
        this.relativeLocation = relativeLocation;
    }

    public String getTerminalImei() {
        return terminalImei;
    }

    public void setTerminalImei(String terminalImei) {
        this.terminalImei = terminalImei;
    }

    public double getMeterRemain() {
        return meterRemain;
    }

    public void setMeterRemain(double meterRemain) {
        this.meterRemain = meterRemain;
    }

    public int getMeterState() {
        return meterState;
    }

    public void setMeterState(int meterState) {
        this.meterState = meterState;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "MeterPO[" +
                "id=" + id +
                ", meterId='" + meterId + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", relativeLocation='" + relativeLocation + '\'' +
                ", terminalImei='" + terminalImei + '\'' +
                ", meterRemain=" + meterRemain +
                ", meterState=" + meterState +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ']';
    }
}
