package com.terabits.meta.po;

/**
 * Created by Administrator on 2017/5/23.
 */
public class MonthPowerPO {
    private int id;
    private String community;
    private String building;
    private String room;
    private double highPower;
    private double lowPower;
    private double sharePower;
    private double charge;
    private String month;
    private String gmtCreate;
    private String gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getHighPower() {
        return highPower;
    }

    public void setHighPower(double highPower) {
        this.highPower = highPower;
    }

    public double getLowPower() {
        return lowPower;
    }

    public void setLowPower(double lowPower) {
        this.lowPower = lowPower;
    }

    public double getSharePower() {
        return sharePower;
    }

    public void setSharePower(double sharePower) {
        this.sharePower = sharePower;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
        return "MonthPowerPO[" +
                "id=" + id +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", highPower=" + highPower +
                ", lowPower=" + lowPower +
                ", sharePower=" + sharePower +
                ", charge=" + charge +
                ", month='" + month + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ']';
    }
}
