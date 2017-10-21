package com.terabits.controller.query;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.po.AlarmPO;
import com.terabits.meta.po.DataPO;
import com.terabits.meta.po.LogPO;
import com.terabits.service.AlarmService;
import com.terabits.service.DataService;
import com.terabits.service.LogService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Controller
public class QueryController {
    @Autowired
    private AlarmService alarmService;
    @Autowired
    private DataService dataService;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/alarm/query", method = RequestMethod.GET)
    public void queryAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
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
        List<AlarmPO> alarmPOS = alarmService.alarmQuery(community, begin, end);
        for (AlarmPO alarmPO : alarmPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("IMEI", alarmPO.getTerminalImei());
            jsonObject.put("type", alarmPO.getAlarmType());
            jsonObject.put("info", alarmPO.getAlarmInfo());
            jsonObject.put("building", alarmPO.getBuilding());
            jsonObject.put("room", alarmPO.getRoom());
            jsonObject.put("time", alarmPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/data/query", method = RequestMethod.GET)
    public void dataAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
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
        PageHelper.startPage(1, 14);
//        List<DataPO> test = dataService.dataQuery(community, begin, end, building, room);
//        PageInfo p = new PageInfo(test);
//        System.out.println("---------------------------");
//        System.out.println(p.getList());
//        System.out.println("---------------------------");
        List<DataPO> buildingPOS = dataService.dataQuery(community, begin, end, building, room);
        for (DataPO buildingPO : buildingPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("building", buildingPO.getBuilding());
            jsonObject.put("room", buildingPO.getRoom());
            jsonObject.put("voltage", buildingPO.getVoltage());
            jsonObject.put("current", buildingPO.getCurrent());
            jsonObject.put("power", buildingPO.getPower());
            jsonObject.put("time", buildingPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/log/query", method = RequestMethod.GET)
    public void logAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
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
        List<LogPO> logPOS = logService.logQuery(community, begin, end);
        for (LogPO logPO : logPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("info", logPO.getLogInfo());
            jsonObject.put("operation", logPO.getOperator());
            jsonObject.put("time", logPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }
}
