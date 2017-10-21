package com.terabits.meta.po;

import com.terabits.meta.bo.ClientInfoBO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
public class MeterClientPO implements Serializable {
	private String community;
    private String building;
    private String room;
    private double remain;
    private List<ClientInfoBO> clients;
    private static final long serialVersionUID = 1L;

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

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public List<ClientInfoBO> getClients() {
        return clients;
    }

    public void setClients(List<ClientInfoBO> clients) {
        this.clients = clients;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "MeterClientPO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", remain=" + remain +
                ", clients=" + clients +
                ']';
    }
}
