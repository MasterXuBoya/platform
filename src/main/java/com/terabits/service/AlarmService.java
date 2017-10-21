package com.terabits.service;

import com.terabits.meta.po.AlarmPO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface AlarmService {
    public List<AlarmPO> alarmQuery(String community, String begin, String end);
    public int getSumAlarm(String community, String time);
    public int insertAlarm(AlarmPO alarmPO);
}
