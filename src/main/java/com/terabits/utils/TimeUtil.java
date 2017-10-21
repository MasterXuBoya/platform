package com.terabits.utils;

import com.terabits.meta.bo.TimeSpanBO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/17.
 */
public class TimeUtil {
 /*   public static void main(String[] args){
        TimeSpanBO timeSpanBO = getTimeSpan();
        String time = timeSpanBO.getEndTime().substring(11,13);
        System.out.println(time.substring(0));
    }*/
    public static TimeSpanBO getTimeSpan(){
        SimpleDateFormat dfs = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        calendar.setTime(end);
        calendar.add(calendar.HOUR, -1);
        Date begin = calendar.getTime();
        TimeSpanBO timeSpanBO = new TimeSpanBO();
        timeSpanBO.setBeginTime(dfs.format(begin));
        timeSpanBO.setEndTime(dfs.format(end));
        return timeSpanBO;
    }
}
