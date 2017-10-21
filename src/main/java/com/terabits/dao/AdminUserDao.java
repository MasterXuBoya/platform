package com.terabits.dao;

import com.terabits.dao.mapper.AdminUserMapper;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import com.terabits.utils.PasswordUtil;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/27.
 */
@Repository("adminUserDao")
public class AdminUserDao {
  /* public static void main(String[] args){
        *//*AdminUserPO adminUserPO = new AdminUserPO();
        adminUserPO.setAccount("003");
        String password = "2154810";
        String newpassword = new String();
        try{
            newpassword = PasswordUtil.EncoderByMd5("003"+"terabits"+password);
        }
        catch (Exception e){
            e.printStackTrace();
        }*//*
        //System.out.println(password);
        //System.out.println(verify("admin", password));
      *//*  adminUserPO.setPassword(newpassword);
        adminUserPO.setName("小王");
        adminUserPO.setPhone("18876333308");
        adminUserPO.setRole("admin");
        adminUserPO.setAuthority("admin:all");
        insertAdminUser(adminUserPO);*//*
        //AdminUserPO adminUserPO= selectAdminUserByAccount("002");
        //System.out.println(PasswordUtil.verify("215481", adminUserPO.getPassword()));
        //List<AdminUserPO> adminUserPOS = new ArrayList<AdminUserPO>();
        //adminUserPOS = selectAllAdminUser();
        System.out.println(selectAdminUserByAccount("003"));
    }*/

    //新增管理用户
    public int insertAdminUser(AdminUserPO adminUserPO){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        try {
            mapper.insertAdminUser(adminUserPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        } finally {
        	session.close();
        }
        return 200;
    }

    //更新管理用户
    public int updateAdminUser(AdminUserPO adminUserPO){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        try {
            mapper.updateAdminUser(adminUserPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        } finally {
        	session.close();
        }
        return 200;
    }

    //根据账户名删除管理用户

    public int deleteAdminUser(String account){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        try {
            mapper.deleteAdminUser(account);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        } finally {
        	session.close();
        }
        return 200;
    }
    //根据账户查询管理用户
    public AdminUserPO selectAdminUserByAccount(String account){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        AdminUserPO adminUserPO = new AdminUserPO();
        try {
            adminUserPO = mapper.selectAdminUserByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return adminUserPO;
    }


    //根据姓名查询管理用户
    public AdminUserVO selectAdminUserVOByAccount(String account){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        AdminUserVO adminUserVO = new AdminUserVO();
        try {
            adminUserVO = mapper.selectAdminUserVOByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return adminUserVO;
    }

    //根据姓名查询管理用户
    public AdminUserVO selectAdminUserByName(String name, String community){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        AdminUserVO adminUserVO = new AdminUserVO();
        try {
            adminUserVO = mapper.selectAdminUserByName(name, community);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminUserVO;
    }

    // 查询全部管理用户
    public List<AdminUserVO> selectAllAdminUser(String community){
        SqlSession session = DBTools.getSession();
        AdminUserMapper mapper = session.getMapper(AdminUserMapper.class);
        List<AdminUserVO> adminUserVOS = new ArrayList<AdminUserVO>();
        try {
            adminUserVOS = mapper.selectAllAdminUser(community);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return adminUserVOS;
    }
}
