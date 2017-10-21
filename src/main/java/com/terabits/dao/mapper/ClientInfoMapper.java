package com.terabits.dao.mapper;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface ClientInfoMapper {
    /**
     * 新增用户数据
     * @param clientInfoPO
     * @return
     * @throws Exception
     */
    public int insertClientInfo(ClientInfoPO clientInfoPO) throws Exception;

    /**
     * 删除用户数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public int deleteClientInfo(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据楼号和室号查询用户数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public List<ClientInfoPO> selectClientInfo(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据用户openid查询楼号和室号
     * @return
     * @throws Exception
     */
    public ClientInfoPO selectClientByOpenId(@Param("openId")String openId) throws Exception;

    /**
     * 查询全部用户数据
     * @return
     * @throws Exception
     */
    public List<ClientInfoPO> selectAllClient(@Param("community")String community) throws Exception;

}
