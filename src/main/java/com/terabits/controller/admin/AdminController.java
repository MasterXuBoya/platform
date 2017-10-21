package com.terabits.controller.admin;

import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;
import com.terabits.service.AdminUserService;
import com.terabits.utils.PasswordUtil;
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
import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller

public class AdminController {
    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    //@RequiresPermissions("")
    public void getAdminUser(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
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
        if(!account.equals("all")){
            AdminUserVO adminUserVO = adminUserService.selectAdminUserVOByAccount(account);
            //JSONObject jsonObject = JSONObject.fromObject(adminUserVO);
            JSONArray jsonArray = JSONArray.fromObject(adminUserVO);
            response.getWriter().print(jsonArray);
            return;
        }
        else if(!name.equals("all")){
            AdminUserVO adminUserVO = adminUserService.getAdminUserByName(name, community);
            JSONArray jsonArray = JSONArray.fromObject(adminUserVO);
            response.getWriter().print(jsonArray);
        }
        else{
            List<AdminUserVO> adminUserVOList = adminUserService.getAllAdminUser(community);
            JSONArray jsonArray = JSONArray.fromObject(adminUserVOList);
            response.getWriter().print(jsonArray);
        }
    }

    @RequestMapping(value = "/user/modify", method = RequestMethod.POST)
    //@RequiresPermissions("")
    public void insertAdminUser(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String authority = request.getParameter("authority");
        String role = "admin";
        String newpassword = new String();
        try{
            newpassword = PasswordUtil.EncoderByMd5(account +"terabits"+password);
            //newpassword = password;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
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
        
        AdminUserPO updateUser = new AdminUserPO();
        updateUser.setAccount(account);
        updateUser.setPassword(newpassword);
        updateUser.setName(name);
        updateUser.setPhone(phone);
        updateUser.setEmail(email);
        updateUser.setAuthority(authority);
        updateUser.setRole(role);
        updateUser.setCommunity(community);
        JSONObject jsonObject = new JSONObject();
        if(request.getParameter("type").equals("0")){
            int result = adminUserService.updateAdminUser(updateUser);
            if(result == 200){
                jsonObject.put("errno", 0);
                jsonObject.put("error", "succ");
                response.getWriter().print(jsonObject);
            }
            else{
                jsonObject.put("errno", 1);
                jsonObject.put("error", "fail");
                response.getWriter().print(jsonObject);
            }
        }
        else if(request.getParameter("type").equals("1")){
            int result = adminUserService.insertAdminUser(updateUser);
            if(result == 200){
                jsonObject.put("errno", 0);
                jsonObject.put("error", "succ");
                response.getWriter().print(jsonObject);
            }
            else{
                jsonObject.put("errno", 1);
                jsonObject.put("error", "fail");
                response.getWriter().print(jsonObject);
            }
        }

    }
}

