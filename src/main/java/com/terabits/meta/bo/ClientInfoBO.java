package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/6/18.
 */
public class ClientInfoBO {
	private String community;
    private String name;
    private String phone;

    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ClientInfoBO[" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ']';
    }
}