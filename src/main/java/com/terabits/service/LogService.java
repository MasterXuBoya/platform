package com.terabits.service;

import com.terabits.meta.po.LogPO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface LogService {
    public List<LogPO> logQuery(String community, String begin, String end);
    public void logInsert(List<LogPO> logPOS);
}
