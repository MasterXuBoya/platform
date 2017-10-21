package com.terabits.meta.po;

import org.springframework.stereotype.Repository;

/**
 * Created by liang on 2017/7/21.
 */
@Repository("homeChartPO")
public class HomeChartPO {
    private int id;
    private String community;
    private int timeId;
    private double electricity;
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

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId){
        this.timeId = timeId;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
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
        return "HomeChartPO{" +
                "id=" + id +
                ", timeId=" + timeId +
                ", electricity=" + electricity +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
