package com.terabits.service;

import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.TerminalPO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface TerminalService {
    public void add(String imei, LogPO logPO) throws Exception;
    public void remove(String imei, LogPO logPO) throws Exception;
    public void change(String oldImei, String newImei, LogPO logPO) throws Exception;
    public List<String> getAllTerminalByCommunity(String community);
    public TerminalPO getTerminalByImei(String imei);
    public TerminalPO getTerminalByTerminalId(String terminalId);
    public void updateFrequency(FrequencyBO frequencyBO, LogPO logPO) throws Exception;
}
