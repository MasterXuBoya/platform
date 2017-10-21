package com.terabits.dao.mapper;

import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface AdminUserMapper {
    /**
     * 新增管理用戶
     * @param adminUserPO
     * @return
     * @throws Exception
     */
    public int insertAdminUser(AdminUserPO adminUserPO) throws Exception;

    /**
     * 根据账户名删除管理用户
     * @return
     * @throws Exception
     */
    public int deleteAdminUser(@Param("account")String account) throws Exception;

    /**
     * 根据账户名查询用户
     * @return
     * @throws Exception
     */
    public AdminUserPO selectAdminUserByAccount(@Param("account")String accout) throws Exception;

    /**
     * 根据账户名查询用户并返回给前端显示
     * @return
     * @throws Exception
     */
    public AdminUserVO selectAdminUserVOByAccount(@Param("account")String accout) throws Exception;

    /**
     * 查询全部管理用户
     * @return
     * @throws Exception
     */
    public List<AdminUserVO> selectAllAdminUser(@Param("community")String community) throws Exception;


    /**
     * 更新管理用戶
     * @param adminUserPO
     * @return
     * @throws Exception
     */
    public int updateAdminUser(AdminUserPO adminUserPO) throws Exception;

    /**
     * 根据姓名名查询用户
     * @return
     * @throws Exception
     */
    public AdminUserVO selectAdminUserByName(@Param("name")String name, @Param("community")String community) throws Exception;


}
