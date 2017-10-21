package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/31.
 */
public class AdminUserBO {
	private String community;
    private String account;
    private String password;

    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUserBO[" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
