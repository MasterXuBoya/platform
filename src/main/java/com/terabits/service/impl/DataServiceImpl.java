package com.terabits.service.impl;

import com.terabits.constant.ProjectGlobal;
import com.terabits.dao.DataDao;
import com.terabits.dao.MeterDao;
import com.terabits.dao.TerminalDao;
import com.terabits.meta.bo.ReceiveDataBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.DataPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.DataService;
import com.terabits.service.MeterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.terabits.utils.BeanToMapUtil.toMap;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("dataService")
public class DataServiceImpl implements DataService{
    @Autowired
    private DataDao buildingDao;
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private MeterService meterService;

    public List<DataPO> dataQuery(String community, String begin, String end, String building, String room) {
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBeginTime(begin);
        selectDataBO.setEndTime(end);
        selectDataBO.setCommunity(community);
        if(!building.equals("all")) {
            selectDataBO.setBuilding(building);
            selectDataBO.setTableName("data_" + community + "_" + building);
            if(!room.equals("all")){
                selectDataBO.setRoom(room);
            }
            return buildingDao.selectData(selectDataBO);
        }
        else{
            List<DataPO> dataPOS = new ArrayList<DataPO>();
            List<String> buildingS = meterService.queryBuilding(community);
	        for(String temp : buildingS) {
	        	selectDataBO.setTableName("data_" + community + "_" + temp);
                List<DataPO> dataPOS1 = buildingDao.selectData(selectDataBO);
                dataPOS.addAll(dataPOS1);
	        }
            return dataPOS;
        }

    }

    public void dataInsert(ReceiveDataBO receiveDataBO) {
        //根据终端ID获得IMEI
        TerminalPO terminalPO = terminalDao.selectOneTerminalById(receiveDataBO.getTerminalId());
        //根据IMEI和电表相对位置获得电表
        MeterPO meterPO = meterDao.selectMeterByRelativeLocation(terminalPO.getTerminalImei(), receiveDataBO.getMeterRelativeLocation());
        String tableName = "data_" + meterPO.getCommunity() + "_" + meterPO.getBuilding();
        List<DataPO> buildingPOS = new ArrayList<DataPO>();
        DataPO buildingPO = new DataPO();
        buildingPO.setBuilding(meterPO.getBuilding());
        buildingPO.setRoom(meterPO.getRoom());
        buildingPO.setCurrent(receiveDataBO.getCurrent());
        buildingPO.setPower(receiveDataBO.getPower());
        buildingPO.setVoltage(receiveDataBO.getVoltage());
        buildingPO.setCommunity(meterPO.getCommunity());
        buildingPOS.add(buildingPO);
        //将要插入的数据和表名封装到Map对象中
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("tablename",tableName);
        params.put("buildingPOS",buildingPOS);
        buildingDao.insertData(params);
    }
    
    public List<TempBusinessDataBO> selectMaxMeterData(String community, String tableName, String time){
        List<TempBusinessDataBO> tempBusinessDataBOS = buildingDao.selectMaxMeterData(community, tableName, time);
        return tempBusinessDataBOS;
    }

    public List<TempBusinessDataBO> selectMinMeterData(String community, String tableName, String time){
        List<TempBusinessDataBO> tempBusinessDataBOS = buildingDao.selectMinMeterData(community, tableName, time);
        return tempBusinessDataBOS;
    }
    
    public void createNewTable(String community, String tableName) {
    	buildingDao.createNewTable(community, tableName);
    }

}
