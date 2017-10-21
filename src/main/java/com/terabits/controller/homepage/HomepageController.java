package com.terabits.controller.homepage;
/***********************************主页*********************************** */
import com.terabits.meta.po.AdminUserPO;
import com.terabits.service.AlarmService;
import com.terabits.service.BusinessService;
import com.terabits.service.HomeChartService;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18.
 */
@Controller
public class HomepageController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private AlarmService alarmService;
    @Autowired
    private HomeChartService homeChartService;
    @RequestMapping(value = {"/display/day"}, method = { RequestMethod.GET })
    public void queryListMember(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String community = adminUserPO.getCommunity();
        
        SimpleDateFormat dfs = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date();
        String currentTime = dfs.format(date) + " 00:00:00";
        Map<String, String> dataMap = new HashMap<String, String>();
        double power = businessService.selectBusinessMeterData(community, currentTime).getPower();
        dataMap.put("power", Double.toString(power));
        int payment = businessService.selectBusinessPaymentData(community, currentTime).getPayment();
        dataMap.put("payment", Integer.toString(payment));
        int alarmCount = alarmService.getSumAlarm(community, currentTime);
        dataMap.put("alarm", Integer.toString(alarmCount));
        JSONObject jsonObject = JSONObject.fromObject(dataMap);
        System.out.println(jsonObject);
        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = {"/display/homechart"}, method = { RequestMethod.GET })
    public void homeChart(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        String community = adminUserPO.getCommunity();
        
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String timeNow = dfs.format(date);
        String dayBegin = timeNow.substring(0, 11) + "00:00:00";
        JSONArray dataList = homeChartService.getHomeChartData(community, dayBegin);
        response.getWriter().print(dataList);
    }
}
