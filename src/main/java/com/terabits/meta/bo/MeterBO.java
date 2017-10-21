package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/24.
 */
public class MeterBO {
	private String community;
    private String building;
    private String room;
    private String terminalImei;
    private double meterRemain;
    private int meterState;

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
}
