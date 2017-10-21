package com.terabits.dao.mapper;

import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.bo.TerminalBO;
import com.terabits.meta.bo.TerminalGroupBO;
import com.terabits.meta.po.TerminalPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface TerminalMapper {
    /**
     * 新增终端数据
     * @param terminalPO
     * @return
     * @throws Exception
     */
    public int insertTerminal(TerminalPO terminalPO) throws Exception;
    /**
     * 更新终端数据
     * @param terminalBO
     * @return
     * @throws Exception
     */
    public int updateTerminal(TerminalBO terminalBO) throws Exception;

    /**
     * 更换终端
     * @param newImei
     * @return
     * @throws Exception
     */
    public int updateTerminalImei(@Param("newImei") String newImei, @Param("oldImei") String oldImei) throws Exception;
    /**
     * 更新频率
     * @param newImei
     * @return
     * @throws Exception
     */
    public int updateFrequency(FrequencyBO frequencyBO) throws Exception;
    /**
     * 更新终端数据sim卡号
     * @throws Exception
     * @return
     */
    public int updateTerminalSimId(@Param("simId")String simId,@Param("terminalImei")String terminalImei) throws Exception;

    /**
     * 更新终端数据sim卡余额
     * @return
     * @throws Exception
     */
    public int updateTerminalSimRemain(@Param("simRemain")double simRemain,@Param("terminalImei")String terminalImei) throws Exception;

    /**
     * 更新终端状态
     * @return
     * @throws Exception
     */
    public int updateTerminalState(@Param("terminalState")int terminalState,@Param("terminalImei")String terminalImei) throws Exception;
    /**
     * 批量更新终端状态
     * @return
     * @throws Exception
     */
    public int updateGroupState(List<TerminalGroupBO> terminalGroupBO) throws Exception;

    /**
     * 更新创建时间
     * @return
     * @throws Exception
     */
    public int updateTerminalCreateTime(@Param("createTime")String createTime, @Param("imei")String imei) throws Exception;


    /**
     * 删除终端
     * @return
     * @throws Exception
     */
    public int deleteTerminal(@Param("terminalImei")String terminalImei) throws Exception;

    /**
     * 根据Imei号查询
     * @return
     * @throws Exception
     */
    public TerminalPO selectOneTerminal(@Param("terminalImei")String terminalImei) throws Exception;

    /**
     * 根据Id号查询
     * @return
     * @throws Exception
     */
    public TerminalPO selectOneTerminalById(@Param("terminalId")String terminalId) throws Exception;

    /**
     * 查询所有终端
     * @return
     * @throws Exception
     */
    public List<TerminalPO> selectAllTerminal() throws Exception;
    
    /**
     * 查询所有终端
     * @return
     * @throws Exception
     */
    public List<TerminalPO> selectAllTerminalByCommunity(@Param("community")String community) throws Exception;
}
