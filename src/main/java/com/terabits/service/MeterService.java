package com.terabits.service;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.MeterStatusVO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface MeterService {
    public void add(List<MeterPO> meterPOS, List<LogPO> logPOS) throws Exception;
    public void remove(List<MeterPO> meterPOS, List<LogPO> logPOS) throws Exception;
    public List<String> queryBuilding(String community);
    public List<String> queryRoom(String community, String building);
    public void setMeterAddress(List<MeterPO> meterPOS) throws Exception;
    public void removeMeterAddress(List<MeterPO> meterPOS) throws Exception;
    public void setMeterState(String terminalId, int relativeLocation, int state);
    public void sendStartOrStopCommand(List<MeterPO> meterPOS, int command, List<LogPO> logPOS) throws Exception;
    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO);
    public List<MeterClientPO> queryMeterClient(LocationBO locationBO);
    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS);
    public List<MeterClientPO> queryForArrearage(String community);
    public List<LocationBO> getAllMeter(String community);
    public int updateMeterRemain(String community, double remain, String building, String room);
}
