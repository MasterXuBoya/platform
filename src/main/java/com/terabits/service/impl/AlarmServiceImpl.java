package com.terabits.service.impl;

import com.terabits.dao.AlarmDao;
import com.terabits.meta.bo.TimeSpanAndCommunityBO;
import com.terabits.meta.po.AlarmPO;
import com.terabits.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{
    @Autowired
    private AlarmDao alarmDao;
    public List<AlarmPO> alarmQuery(String community, String begin, String end) {
        TimeSpanAndCommunityBO timeSpanAndCommunityBO = new TimeSpanAndCommunityBO();
        timeSpanAndCommunityBO.setBeginTime(begin);
        timeSpanAndCommunityBO.setEndTime(end);
        timeSpanAndCommunityBO.setCommunity(community);
        return alarmDao.selectAlarmByTime(timeSpanAndCommunityBO);
    }
    public int getSumAlarm(String community, String time){
        return alarmDao.getSumAlarm(community, time);
    }
    public int insertAlarm(AlarmPO alarmPO) {
		return alarmDao.insertAlarm(alarmPO);
	}
}
