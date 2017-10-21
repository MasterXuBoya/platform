package com.terabits.meta.vo;

/**
 * Created by Administrator on 2017/6/19.
 */
public class MeterStatusVO {
    private String building;
    private String room;
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MeterStatusVO[" +
                "building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", status=" + status +
                ']';
    }
}
