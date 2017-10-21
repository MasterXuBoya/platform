package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/25.
 */
public class TerminalBO {
	private String community;
    private String terminalImei;
    private String simId;
    private double simRemain;
    private int terminalState;

    public String getCommunity() {
    	return this.community;
    }
    
    public void setCommunity(String community) {
    	this.community = community;
    }
    
    public String getTerminalImei() {
        return terminalImei;
    }

    public void setTerminalImei(String terminalImei) {
        this.terminalImei = terminalImei;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public double getSimRemain() {
        return simRemain;
    }

    public void setSimRemain(double simRemain) {
        this.simRemain = simRemain;
    }

    public int getTerminalState() {
        return terminalState;
    }

    public void setTerminalState(int terminalState) {
        this.terminalState = terminalState;
    }

    @Override
    public String toString() {
        return "TerminalBO[" +
                "terminalImei='" + terminalImei + '\'' +
                ", simId='" + simId + '\'' +
                ", simRemain=" + simRemain +
                ", terminalState=" + terminalState +
                ']';
    }
}
