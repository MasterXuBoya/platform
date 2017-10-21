package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ReceiveDataBO {
    private String terminalId;
    private int meterRelativeLocation;
    private double power;
    private double voltage;
    private double current;

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalId(){
        return this.terminalId;
    }

    public void setMeterRelativeLocation(int meterRelativeLocation) {
        this.meterRelativeLocation = meterRelativeLocation;
    }

    public int getMeterRelativeLocation() {
        return this.meterRelativeLocation;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getPower() {
        return this.power;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getVoltage() {
        return this.voltage;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getCurrent() {
        return this.current;
    }
}
