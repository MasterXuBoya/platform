package com.terabits.meta.po;

/**
 * Created by Administrator on 2017/5/23.
 */
public class TerminalPO {
    private int id;
    private String community;
    private String terminalImei;
    private String terminalId;
    private String simId;
    private double simRemain;
    private int frequencyHeart;
    private int frequencyTask;
    private int terminalState;
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

    public String getTerminalImei() {
        return terminalImei;
    }

    public void setTerminalImei(String terminalImei) {
        this.terminalImei = terminalImei;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
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
    
    public int getFrequencyHeart() {
        return frequencyHeart;
    }

    public void setFrequencyHeart(int frequencyHeart) {
        this.frequencyHeart = frequencyHeart;
    }
    
    public int getFrequencyTask() {
        return frequencyTask;
    }

    public void setFrequencyTask(int frequencyTask) {
        this.frequencyTask = frequencyTask;
    }

    public int getTerminalState() {
        return terminalState;
    }

    public void setTerminalState(int terminalState) {
        this.terminalState = terminalState;
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
        return "TerminalPO[" +
                "id=" + id +
                ", terminalImei='" + terminalImei + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", simId='" + simId + '\'' +
                ", simRemain='" + simRemain + '\'' +
                ", terminalState=" + terminalState +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ']';
    }
}
