package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/25.
 */
public class TerminalGroupBO {
    private int state;
    private String imei;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "TerminalGroupBO[" +
                "state=" + state +
                ", imei='" + imei + '\'' +
                ']';
    }
}
