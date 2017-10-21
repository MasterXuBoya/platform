package com.terabits.service;

import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface AdminUserService {
    public AdminUserPO getAdminUserByAccount(String account);
    public AdminUserVO getAdminUserByName(String name, String community);
    public int insertAdminUser(AdminUserPO adminUserPO);
    public int updateAdminUser(AdminUserPO adminUserPO);
    public List<AdminUserVO> getAllAdminUser(String community);
    public AdminUserVO selectAdminUserVOByAccount(String account);
}
