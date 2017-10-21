package com.terabits.service;

import com.terabits.meta.bo.ReceiveDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.DataPO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface DataService {
    public List<DataPO> dataQuery(String community, String begin, String end, String building, String room);
    public void dataInsert(ReceiveDataBO receiveDataBO);
    public List<TempBusinessDataBO> selectMaxMeterData(String community, String tableName, String time);
    public List<TempBusinessDataBO> selectMinMeterData(String community, String tableName, String time);
    public void createNewTable(String community, String tableName);
}
