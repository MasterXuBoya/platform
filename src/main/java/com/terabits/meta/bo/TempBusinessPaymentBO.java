package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/6/15.
 */
public class TempBusinessPaymentBO {
	private String community;
    private String building;
    private String room;
    private int tempPayment;

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

    public int getTempPayment() {
        return tempPayment;
    }

    public void setTempPayment(int tempPayment) {
        this.tempPayment = tempPayment;
    }

    @Override
    public String toString() {
        return "TempBusinessPaymentBO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", tempPayment=" + tempPayment +
                ']';
    }
}
