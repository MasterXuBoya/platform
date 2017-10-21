package com.terabits.controller.xhr.meterstatus;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.MeterStatusVO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
@Controller
public class MeterStatusController {
    @Autowired
    private MeterService meterService;
    @RequestMapping(value = {"/xhr/meter/data"}, method = { RequestMethod.GET})
    public void queryPaymentInfo(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
    	
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
    	
        List<LocationBO> locationBOS = new ArrayList<LocationBO>();
        LocationBO locationBO = new LocationBO();
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        locationBO.setCommunity(community);
        if(!building.equals("all")){
            locationBO.setBuilding(building);
        }
        if(!room.equals("all")){
            locationBO.setRoom(room);
            locationBOS.add(locationBO);
        }
        else{
            locationBOS = meterService.getAllMeter(community);
        }
        List<MeterStatusVO> meterStatusVOList = meterService.selectListMeter(locationBOS);
        System.out.println(meterStatusVOList);
        JSONArray jsonArray = JSONArray.fromObject(meterStatusVOList);
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }
}
