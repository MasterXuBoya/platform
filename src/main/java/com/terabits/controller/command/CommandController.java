package com.terabits.controller.command;

import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.service.MeterService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/6/7.
 */
@Controller
public class CommandController {

    @Autowired
    private MeterService meterService;

    @RequestMapping(value = "/command/start_stop", method = RequestMethod.POST)
    public void startStop(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
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
        
        JSONArray data = JSONArray.fromObject(request.getParameter("data"));
        int command = Integer.valueOf(request.getParameter("command"));
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        for (int i = 0; i < data.size(); i++) {
        	JSONObject temp = (JSONObject) data.get(i);
        	String building = temp.getString("building");
        	String room = temp.getString("room");
        	MeterPO meterPO = new MeterPO();
        	meterPO.setBuilding(building);
        	meterPO.setRoom(room);
        	meterPO.setCommunity(adminUserPO.getCommunity());
        	meterPOS.add(meterPO);
        }
        //日志信息

        List<LogPO> logPOS = new ArrayList<LogPO>();
        for(int i = 0; i < meterPOS.size(); i++) {
        	LogPO logPO = new LogPO();
        	String building = meterPOS.get(i).getBuilding();
            String room = meterPOS.get(i).getRoom();
            if (command == 0) {
            	logPO.setLogInfo("关闭电表：" + building + "-" + room);
            } else {
            	logPO.setLogInfo("开启电表：" + building + "-" + room);
            }
            logPO.setOperator(user);
            logPO.setCommunity(adminUserPO.getCommunity());
            logPOS.add(logPO);
        }
        try {
            meterService.sendStartOrStopCommand(meterPOS, command, logPOS);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
}
