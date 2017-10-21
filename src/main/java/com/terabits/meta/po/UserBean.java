package com.terabits.meta.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/25.
 */

public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String community;
    private String username;
    private String password;
    private Double account;

    public UserBean() {
        super();
    }

    public UserBean(String username, String password, Double account) {
        super();
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public UserBean(Integer id, String username, String password, Double account) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username + ", password="
                + password + ", account=" + account + "]";
    }
}