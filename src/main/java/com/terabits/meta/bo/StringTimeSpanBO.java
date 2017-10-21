package com.terabits.meta.bo;

/**
 * Created by Administrator on 2017/5/27.
 */
public class StringTimeSpanBO {
    private String beginTime;
    private String endTime;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StringTimeSpanBO[" +
                "beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ']';
    }
}
