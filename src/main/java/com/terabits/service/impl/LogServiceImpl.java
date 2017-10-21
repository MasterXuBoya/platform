package com.terabits.service.impl;

import com.terabits.dao.LogDao;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TimeSpanAndCommunityBO;
import com.terabits.meta.po.LogPO;
import com.terabits.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("logService")
public class LogServiceImpl implements LogService{
    @Autowired
    private LogDao logDao;
    public List<LogPO> logQuery(String community, String begin, String end) {
        TimeSpanAndCommunityBO timeSpanAndCommunityBO = new TimeSpanAndCommunityBO();
        timeSpanAndCommunityBO.setBeginTime(begin);
        timeSpanAndCommunityBO.setEndTime(end);
        timeSpanAndCommunityBO.setCommunity(community);
        return logDao.selectLog(timeSpanAndCommunityBO);
    }

    public void logInsert(List<LogPO> logPOS) {
        for (LogPO logPO : logPOS) {
            logDao.insertLog(logPO);
        }
    }
}
