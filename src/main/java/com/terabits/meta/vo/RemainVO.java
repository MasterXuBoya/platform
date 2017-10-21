package com.terabits.meta.vo;

/**
 * Created by Administrator on 2017/5/23.
 */
public class RemainVO {
    private String building;
    private String room;
    private String name;
    private String phone;
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

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "RemainVO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", remain=" + remain +
                ']';
    }
}
