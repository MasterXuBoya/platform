package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/6/15.
 */
public class TempBusinessDataBO {
	private String community;
    private String building;
    private String room;
    private double tempPower;

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

    public double getTempPower() {
        return tempPower;
    }

    public void setTempPower(double tempPower) {
        this.tempPower = tempPower;
    }

    @Override
    public String toString() {
        return "TempBusinessDataBO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", tempPower=" + tempPower +
                ']';
    }
}
