package com.terabits.utils;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/6/18.
 */
public class TempUtil {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        int i  = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(i);
    }
}
