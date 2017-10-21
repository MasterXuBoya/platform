package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/26.
 */
public class DataBO {
    private String meterId;
    private double voltage;
    private double current;
    private double power;

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "DataBO[" +
                "meterId='" + meterId + '\'' +
                ", voltage=" + voltage +
                ", current=" + current +
                ", power=" + power +
                ']';
    }
}
