package com.terabits.meta.vo;

/**
 * Created by Administrator on 2017/6/18.
 */
public class PaymentVO {
    private String building;
    private String room;
    private int payment;
    private String time;
    private double remain;

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

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "PaymentVO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", payment=" + payment +
                ", time='" + time + '\'' +
                ", remain=" + remain +
                ']';
    }
}
