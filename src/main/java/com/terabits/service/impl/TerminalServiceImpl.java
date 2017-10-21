package com.terabits.service.impl;

import com.terabits.dao.LogDao;
import com.terabits.dao.TerminalDao;
import com.terabits.dao.MeterDao;
import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.TerminalService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.terabits.iotconnetion.HttpsUtil;
import com.terabits.iotconnetion.PlatformGlobal;
import com.terabits.iotconnetion.JsonUtil;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service("terminalService")
public class TerminalServiceImpl implements TerminalService {
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private LogDao logDao;

    public void add(String imei, LogPO logPO) throws Exception{
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        if (adminUserPO == null) {
        	throw new Exception("请重新登录。");
        }
        String community = adminUserPO.getCommunity();
        
        //检查IMEI号是否已注册
        List<TerminalPO> terminalPOS = terminalDao.selectAllTerminal();
        for (int i = 0; i < terminalPOS.size(); i++) {
            if (imei.equals(terminalPOS.get(i).getTerminalImei())) {
                throw new Exception("IMEI号已注册。");
            }
        }
        //注册设备
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = PlatformGlobal.login(httpsUtil);
        String EndUserId = "currentuser";

        Map<String, Object> paramReg = new HashMap<String, Object>();
        paramReg.put("verifyCode", imei);
        paramReg.put("nodeId", imei);
        paramReg.put("endUserId", EndUserId);
        paramReg.put("timeout", 0);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramReg);

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", PlatformGlobal.appId);
        header.put("Authorization", "Bearer " + accessToken);

        String bodyReg = httpsUtil.doPostJsonForString(PlatformGlobal.urlReg, header,
                jsonRequest);

        Map<String, String> data = new HashMap<String, String>();
        data = JsonUtil.jsonString2SimpleObj(bodyReg, data.getClass());
        String deviceId = data.get("deviceId");

        System.out.println(bodyReg);

        //设置设备信息
        String urlSetDeviceInfo = PlatformGlobal.urlSetDeviceInfo + deviceId;

        Map<String, Object> paramSetDeviceInfo = new HashMap<String, Object>();
        paramSetDeviceInfo.put("manufacturerId", PlatformGlobal.manufacturerId);
        paramSetDeviceInfo.put("manufacturerName", PlatformGlobal.manufacturerName);
        paramSetDeviceInfo.put("deviceType", PlatformGlobal.deviceType);
        paramSetDeviceInfo.put("protocolType", PlatformGlobal.protocolType);
        paramSetDeviceInfo.put("model", PlatformGlobal.model);

        jsonRequest = JsonUtil.jsonObj2Sting(paramSetDeviceInfo);
        String bodyModifyDeviceInfo = httpsUtil.doPutJsonForString(urlSetDeviceInfo, header, jsonRequest);

        //数据库操作
        TerminalPO terminalPO = new TerminalPO();
        terminalPO.setTerminalImei(imei);
        terminalPO.setTerminalId(deviceId);
        terminalPO.setTerminalState(1);
        terminalPO.setCommunity(community);

        int result = terminalDao.insertTerminal(terminalPO);
        if (result == 400) {
            throw new Exception("采集器添加失败。");
        }

        //添加日志
        if (logPO != null)
            logDao.insertLog(logPO);
    }
    public void remove(String imei, LogPO logPO) throws Exception{
        //检查IMEI号是否已注册
        List<TerminalPO> terminalPOS = terminalDao.selectAllTerminal();
        int flag = 0;
        for (int i = 0; i < terminalPOS.size(); i++) {
            if (imei.equals(terminalPOS.get(i).getTerminalImei())) {
                flag = 1;
            }
        }
        if (flag == 0) {
            throw new Exception("IMEI号未注册。");
        }
        //删除设备
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = PlatformGlobal.login(httpsUtil);
        TerminalPO ternimalPO = terminalDao.selectOneTerminal(imei);
        String deviceId = ternimalPO.getTerminalId();
        String urlDelete = PlatformGlobal.urlDelete + deviceId;

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", PlatformGlobal.appId);
        header.put("Authorization", "Bearer " + accessToken);

        String bodyDelete = httpsUtil.doDeleteForString(urlDelete, header);

        //数据库操作，删除终端和终端下的电表
        int result = terminalDao.deleteTerminal(imei);
        if (result == 400) {
            throw new Exception("采集器删除失败。");
        }
        //添加日志
        if (logPO != null)
            logDao.insertLog(logPO);
    }
    public void change(String oldImei, String newImei, LogPO logPO) throws Exception{
        //检查IMEI号是否已注册
        List<TerminalPO> terminalPOS = terminalDao.selectAllTerminal();
        for (int i = 0; i < terminalPOS.size(); i++) {
            if (newImei.equals(terminalPOS.get(i).getTerminalImei())) {
                throw new Exception("新IMEI号已注册。");
            }
        }
        int flag = 0;
        for (int i = 0; i < terminalPOS.size(); i++) {
            if (oldImei.equals(terminalPOS.get(i).getTerminalImei())) {
                flag = 1;
            }
        }
        if (flag == 0) {
            throw new Exception("原IMEI号未注册。");
        }
        //考虑外键约束，先注册新终端
        try {
            add(newImei, null);
        } catch(Exception e) {
            throw new Exception("采集器更换失败。");
        }
        TerminalPO ternimalNew = terminalDao.selectOneTerminal(newImei);
        TerminalPO ternimalOld = terminalDao.selectOneTerminal(oldImei);
        //更新电表关联终端IMEI号
        int result = meterDao.updateGroupImei(ternimalNew.getTerminalImei(), ternimalOld.getTerminalImei());
        if (result == 400) {
            throw new Exception("采集器更换失败。");
        }
        //删除原终端
        try {
            remove(oldImei, null);
        } catch (Exception e) {
            throw new Exception("采集器更换成功，原终端删除失败，请手动删除。");
        }

        //添加日志
        logDao.insertLog(logPO);
    }

    public List<String> getAllTerminalByCommunity(String community) {
        List<TerminalPO> terminalPOS = terminalDao.selectAllTerminalByCommunity(community);
        List<String> imeiS = new ArrayList<String>();
        for (TerminalPO terminalPO : terminalPOS) {
            imeiS.add(terminalPO.getTerminalImei());
        }
        return imeiS;
    }

    public TerminalPO getTerminalByImei(String imei) {
        return terminalDao.selectOneTerminal(imei);
    }

    public TerminalPO getTerminalByTerminalId(String terminalId) {
		return terminalDao.selectOneTerminalById(terminalId);
	}
    
	public void updateFrequency(FrequencyBO frequencyBO, LogPO logPO) throws Exception{
		int result = terminalDao.updateFrequency(frequencyBO);
		if (result == 400) {
            throw new Exception("时间设置失败。");
        }
		//添加日志
		if (logPO != null) {
			logDao.insertLog(logPO);
		}
	}
}
