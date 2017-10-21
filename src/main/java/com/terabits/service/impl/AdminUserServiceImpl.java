package com.terabits.service.impl;

import com.terabits.dao.AdminUserDao;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;
import com.terabits.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    public AdminUserPO getAdminUserByAccount(String account){
        return adminUserDao.selectAdminUserByAccount(account);
    }
    public AdminUserVO getAdminUserByName(String name, String community){
        return adminUserDao.selectAdminUserByName(name, community);
    }
    public int insertAdminUser(AdminUserPO adminUserPO){
        return adminUserDao.insertAdminUser(adminUserPO);
    }
    public int updateAdminUser(AdminUserPO adminUserPO){
        return adminUserDao.updateAdminUser(adminUserPO);
    }

    public List<AdminUserVO> getAllAdminUser(String community){
        return adminUserDao.selectAllAdminUser(community);
    }
    public AdminUserVO selectAdminUserVOByAccount(String account){
        return adminUserDao.selectAdminUserVOByAccount(account);
    }
}
