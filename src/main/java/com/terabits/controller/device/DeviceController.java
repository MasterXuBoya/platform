package com.terabits.controller.device;

import com.terabits.iotconnetion.CodecComponent;
import com.terabits.iotconnetion.PlatformGlobal;
import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.impl.TerminalServiceImpl;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.terabits.service.TerminalService;
import com.terabits.service.MeterService;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
public class DeviceController {
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private MeterService meterService;

    @RequestMapping(value = "/terminal/query", method = RequestMethod.GET)
    public void queryTerminal(HttpServletResponse response) throws Exception {
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        if (adminUserPO == null) {
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("errno", 1);
        	jsonObject.put("error", "请重新登录。");
        	response.getWriter().print(jsonObject);
        	return;
        }
        String community = adminUserPO.getCommunity();
        
        List<String> imeiS = terminalService.getAllTerminalByCommunity(community);
        JSONArray jsonArray = new JSONArray();
        for (String imei : imeiS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("IMEI", imei);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/terminal/add", method = RequestMethod.POST)
    public void addTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imei = request.getParameter("imei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }

        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("添加终端：" + imei);
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            terminalService.add(imei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }

    @RequestMapping(value = "/terminal/remove", method = RequestMethod.POST)
    public void removeTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imei = request.getParameter("imei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }
        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("删除终端：" + imei);
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            terminalService.remove(imei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }

    @RequestMapping(value = "/terminal/change", method = RequestMethod.POST)
    public void changeTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String oldImei = request.getParameter("oldImei");
        String newImei = request.getParameter("newImei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }
        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("更换终端：原终端" + oldImei + "，新终端" + newImei);
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            terminalService.change(oldImei, newImei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
    
    @RequestMapping(value = "/terminal/frequency", method = RequestMethod.POST)
    public void frequencySetting(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }
    	
    	String imei = request.getParameter("imei");
    	int time1 = Integer.valueOf(request.getParameter("time1"));
    	int time2 = Integer.valueOf(request.getParameter("time2"));
    	int time1_high = time1 / 100;
    	int time1_low = time1 % 100;
    	int time2_high = time2 / 100;
    	int time2_low = time2 % 100;
    	
    	//保存原有频率
    	FrequencyBO preFrequencyBO = new FrequencyBO();
    	preFrequencyBO.setFrequencyHeart(terminalService.getTerminalByImei(imei).getFrequencyHeart());
    	preFrequencyBO.setFrequencyTask(terminalService.getTerminalByImei(imei).getFrequencyTask());
    	preFrequencyBO.setImei(imei);
    	
    	//更新频率为-1（可修改）
    	FrequencyBO frequencyBO = new FrequencyBO();
    	frequencyBO.setFrequencyHeart(-1);
    	frequencyBO.setFrequencyTask(-1);
    	frequencyBO.setImei(imei);
    	
    	try {
    		terminalService.updateFrequency(frequencyBO, null);
    	} catch (Exception e) {
    		JSONObject jsonObject = new JSONObject();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
            return;
    	}

    	//生成透传命令
    	byte[] commandBytes = new byte[6];
    	commandBytes[0] = CodecComponent.FREQUENCY_HEAD;
    	commandBytes[1] = (byte)((time1_high / 10) * 16 + time1_high % 10);
    	commandBytes[2] = (byte)((time1_low / 10) * 16 + time1_low % 10);
    	commandBytes[3] = (byte)((time2_high / 10) * 16 + time2_high % 10);
    	commandBytes[4] = (byte)((time2_low / 10) * 16 + time2_low % 10);
    	commandBytes[5] = CodecComponent.FREQUENCY_END;
    	PlatformGlobal.command(commandBytes, terminalService.getTerminalByImei(imei).getTerminalId());
    	//重传命令
    	for (int i = 0; i < 3; i++) {
    		Thread.sleep(5000);
    		TerminalPO terminalPO = terminalService.getTerminalByImei(imei);
    		if (terminalPO.getFrequencyHeart() == 0 && terminalPO.getFrequencyTask() == 0) {
    			//更新数据库
    			LogPO logPO = new LogPO();
                logPO.setLogInfo("更新终端频率。");
                logPO.setOperator(user);
                logPO.setCommunity(adminUserPO.getCommunity());
    			FrequencyBO fre = new FrequencyBO();
    			fre.setFrequencyHeart(time1);
    			fre.setFrequencyTask(time2);
    			fre.setImei(imei);
    			terminalService.updateFrequency(fre, logPO);
    	    	
    			JSONObject jsonObject = new JSONObject();
                jsonObject.put("errno", 0);
                jsonObject.put("error", "");
                response.getWriter().print(jsonObject);
                return;
    		} else {
    			if (i == 2) {
    				//恢复原有频率
    				LogPO logPO = new LogPO();
                    logPO.setLogInfo("更新终端频率失败。");
                    logPO.setOperator(user);
                    logPO.setCommunity(adminUserPO.getCommunity());
    				terminalService.updateFrequency(preFrequencyBO, logPO);
    				JSONObject jsonObject = new JSONObject();
                    jsonObject.put("errno", 1);
                    jsonObject.put("error", "时间设置失败。");
                    response.getWriter().print(jsonObject);
                    return;
    			}
    			PlatformGlobal.command(commandBytes, terminalPO.getTerminalId());
    		}
    	}
    }
    @RequestMapping(value = "/meter/query", method = RequestMethod.GET)
    public void queryMeter(HttpServletResponse response) throws Exception{
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        if (adminUserPO == null) {
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("errno", 1);
        	jsonObject.put("error", "请重新登录。");
        	response.getWriter().print(jsonObject);
        	return;
        }
        String community = adminUserPO.getCommunity();
        
        JSONArray jsonArray = new JSONArray();
        List<String> buildingS = meterService.queryBuilding(community);
        for (String building : buildingS) {
            List<String> roomS = meterService.queryRoom(community, building);
            String roomR = "";
            for (String room : roomS) {
                roomR += room + ".";
            }
            roomR = roomR.substring(0, roomR.length() - 1);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("building", building);
            jsonObject.put("room", roomR);
            jsonArray.add(jsonObject);
        }
        response.getWriter().print(jsonArray);
    }
    @RequestMapping(value = "/meter/add", method = RequestMethod.POST)
    public void addMeter(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String imei = request.getParameter("imei");
        JSONArray data = JSONArray.fromObject(request.getParameter("data"));
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        for (int i = 0; i < data.size(); i++) {
        	JSONObject jsonObject = (JSONObject) data.get(i);
        	String building = jsonObject.getString("building");
        	if (building.length() == 1) {
                building = "0" + building;
            }
            String room = jsonObject.getString("room");
            String meterId = jsonObject.getString("meterId");
            MeterPO meterPO = new MeterPO();
            meterPO.setMeterId(meterId);
            meterPO.setBuilding(building);
            meterPO.setRoom(room);
            meterPO.setTerminalImei(imei);
            meterPO.setMeterRemain(0);
            meterPO.setMeterState(0);
            meterPOS.add(meterPO);
        }
        
        //日志信息
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }
        List<LogPO> logPOS = new ArrayList<LogPO>();
        for(int i = 0; i < meterPOS.size(); i++) {
        	LogPO logPO = new LogPO();
        	String building = meterPOS.get(i).getBuilding();
            String room = meterPOS.get(i).getRoom();
            logPO.setLogInfo("添加电表：" + building + "-" + room);
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            logPOS.add(logPO);
        }
        try {
            meterService.add(meterPOS, logPOS);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
    @RequestMapping(value = "/meter/remove", method = RequestMethod.POST)
    public void removeMeter(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String building = request.getParameter("building");
    	if (building.length() == 1) {
            building = "0" + building;
        }
    	String room = request.getParameter("room");
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        MeterPO meterPO = new MeterPO();
        meterPO.setBuilding(building);
        meterPO.setRoom(room);
        meterPOS.add(meterPO);
        
        //日志信息
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String user = null;
        try {
        	user = adminUserPO.getAccount();
        } catch(Exception e) {
        	jsonObject.put("errno", 1);
            jsonObject.put("error", "请重新登录。");
            response.getWriter().print(jsonObject);
            return;
        }
        List<LogPO> logPOS = new ArrayList<LogPO>();
        for(int i = 0; i < meterPOS.size(); i++) {
        	LogPO logPO = new LogPO();
            logPO.setLogInfo("删除电表：" + meterPOS.get(i).getBuilding() + "-" + meterPOS.get(i).getRoom());
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            logPOS.add(logPO);
        }
        try {
            meterService.remove(meterPOS, logPOS);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
}
