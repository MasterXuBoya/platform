package com.terabits.dao.mapper;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.MeterBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.MeterStatusVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface MeterMapper {
    /**
     * 新增电表数据
     * @param meterPO
     * @return
     * @throws Exception
     */
    public int insertMeter(Map<String,Object> params) throws Exception;
    /**
     * 修改电表数据
     * @param meterBO
     * @return
     * @throws Exception
     */
    public int updateMeter (MeterBO meterBO) throws Exception;
    /**
     * 修改电表Imei号
     * @param terminalImei
     * @param building
     * @param room
     * @return
     * @throws Exception
     */
    public int updateMeterImei(@Param("community") String community, @Param("terminalImei") String terminalImei, @Param("building") String building, @Param("room") String room) throws Exception;
    /**
     * 修改电表余额
     * @param meterRemain
     * @param building
     * @param room
     * @return
     * @throws Exception
     */

    public int updateMeterRemain (@Param("community") String community, @Param("meterRemain") Double meterRemain, @Param("building") String building, @Param("room") String room) throws Exception;

    /**
     * 修改电表状态
     * @param meterState
     * @param building
     * @param room
     * @return
     * @throws Exception
     */

    public int updateMeterState (@Param("community") String community, @Param("meterState")int meterState, @Param("building")String building, @Param("room")String room) throws Exception;

    /**
     * 批量修改电表Imei号，在更换终端时使用
     * @return
     * @throws Exception
     */
    public int updateGroupImei (@Param("newImei")String newImei, @Param("oldImei") String oldImei) throws Exception;

    /**
     * 刪除电表数据
     * @param building
     * @param room
     * @return
     * @throws Exception
     */
    public int deleteMeter(@Param("community") String community, @Param("building")String building, @Param("room")String room) throws Exception;

    /**
     * 批量删除电表
     * @param imei
     * @return
     * @throws Exception
     */
    public int deleteGroupMeter(@Param("imei")String imei) throws Exception;

    /**
     * 根据building和room查询电表信息
     * @param building
     * @param room
     * @return
     * @throws Exception
     */
    public MeterPO selectOneMeter(@Param("community") String community, @Param("building")String building, @Param("room")String room) throws Exception;

    /**
     * 根据终端imei和电表相对位置查询电表
     * @param meterPO
     * @return
     * @throws Exception
     */
    public MeterPO selectMeterByRelativeLocation(MeterPO meterPO) throws Exception;

    /**
     * 根据终端imei查询电表
     * @param imei
     * @return
     * @throws Exception
     */
    public List<MeterPO> selectMeterByImei(@Param("imei")String imei) throws Exception;

    /**
    * 根据building查询电表信息
    * @param building
    * @return
    * @throws Exception
    */
    public List<MeterPO> selectMeterByBuilding(@Param("community") String community, @Param("building") String building) throws Exception;

    /**
     * 查询所有的电表信息
     * @return
     * @throws Exception
     */
    public List<MeterPO> selectAllMeter(@Param("community") String community) throws Exception;

    /**
     * 查询所有的楼号
     */
    public List<String> selectAllBuilding(@Param("community") String community) throws Exception;

    /**
     * 根据楼号查询所有房间
     * @param building
     * @return
     * @throws Exception
     */
    public List<String> selectAllRoomByBuilding(@Param("community") String community, @Param("building")String building) throws Exception;

    /**
     * 查询终端下所有电表的相对位置
     * @param imei
     * @return
     * @throws Exception
     */
    public List<Integer> selectAllRelativeLocationByImei(@Param("imei")String imei) throws  Exception;

    //根据building和room查询电表信息
    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO) throws Exception;

    //联表查询 根据building和room查remain，client_name和client_phone
    public List<MeterClientPO> queryForList(LocationBO locationBO) throws Exception;

    //查询全部欠费用户
    public List<MeterClientPO> queryForArrearage(@Param("community") String community) throws Exception;

    //根据楼号和室号批量查询电表状态
    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS) throws Exception;

    //获取当前数据库中的全部电表的位置
    public List<LocationBO> getMeterLocation(@Param("community") String community) throws Exception;
}

