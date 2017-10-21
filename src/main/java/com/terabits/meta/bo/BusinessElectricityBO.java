package com.terabits.meta.bo;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/15.
 */
public class BusinessElectricityBO {
	private String community;
    private HashMap<String, Double> electricity;

    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }
    
    public HashMap<String, Double> getElectricity() {
        return electricity;
    }

    public void setElectricity(HashMap<String, Double> electricity) {
        this.electricity = electricity;
    }
}
