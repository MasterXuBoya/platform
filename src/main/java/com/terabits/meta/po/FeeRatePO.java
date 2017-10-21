package com.terabits.meta.po;

/**
 * Created by Administrator on 2017/5/23.
 */
public class FeeRatePO {
    private int id;
    private String highStartTime;
    private String highOverTime;
    private double highPrice;
    private String lowStartTime;
    private String lowOverTime;
    private double lowPrice;
    private String gmtCreate;
    private String gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHighStartTime() {
        return highStartTime;
    }

    public void setHighStartTime(String highStartTime) {
        this.highStartTime = highStartTime;
    }

    public String getHighOverTime() {
        return highOverTime;
    }

    public void setHighOverTime(String highOverTime) {
        this.highOverTime = highOverTime;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowStartTime() {
        return lowStartTime;
    }

    public void setLowStartTime(String lowStartTime) {
        this.lowStartTime = lowStartTime;
    }

    public String getLowOverTime() {
        return lowOverTime;
    }

    public void setLowOverTime(String lowOverTime) {
        this.lowOverTime = lowOverTime;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
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
        return "FeeRatePO[" +
                "id=" + id +
                ", highStartTime='" + highStartTime + '\'' +
                ", highOverTime='" + highOverTime + '\'' +
                ", highPrice=" + highPrice +
                ", lowStartTime='" + lowStartTime + '\'' +
                ", lowOverTime='" + lowOverTime + '\'' +
                ", lowPrice=" + lowPrice +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ']';
    }
}
