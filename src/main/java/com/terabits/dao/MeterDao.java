package com.terabits.dao;

import com.sun.xml.internal.ws.api.model.MEP;
import com.terabits.dao.mapper.MeterMapper;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.MeterBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.MeterStatusVO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository("meterDao")
public class MeterDao {
  /*  public static void main(String args[]){
        LocationBO locationBO = new LocationBO();
        locationBO.setBuilding("01");
        locationBO.setRoom("102");
        System.out.println(queryMeterClient(locationBO));
    }*/
    //新增电表数据
    public int insertMeter(Map<String,Object> params) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.insertMeter(params);
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
    //更新Imei号，余额以及状态
    public int updateMeter(MeterBO meterBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeter(meterBO);
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
    //根据楼号和室号更新Imei号
    public int updateMeterImei(String community, String terminalImei, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeterImei(community, terminalImei,building,room);
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
    //根据楼号和室号更新余额
    public int updateMeterRemain(String community, double remain, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeterRemain(community, remain,building,room);
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
    //根据楼号和室号更新状态
    public int updateMeterState(String community, int state, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
        	if (state == 3) {
        		mapper.deleteMeter(community, building, room);
        	} else {
        		mapper.updateMeterState(community, state,building,room);
        	}
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
    //更换终端时使用
    public int updateGroupImei(String newImei, String oldImei){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateGroupImei(newImei,oldImei);
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
    //删除电表
    public int deleteMeter(String community, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.deleteMeter(community, building,room);
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
    //批量删除电表
    public int deleteGroupMeter(String imei) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.deleteGroupMeter(imei);
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
    //根据楼号和室号选择一台电表
    public MeterPO selectOneMeter(String community, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        MeterPO meterPO = null;
        try {
            meterPO = mapper.selectOneMeter(community, building,room);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPO;
    }
    //根据终端imei和电表相对位置选择一台电表
    public MeterPO selectMeterByRelativeLocation(String imei, int relativeLocation){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        MeterPO meterPO = new MeterPO();
        try {
            MeterPO meter = new MeterPO();
            meter.setRelativeLocation(relativeLocation);
            meter.setTerminalImei(imei);
            meterPO = mapper.selectMeterByRelativeLocation(meter);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPO;
    }
    //根据终端imei选择一台电表
    public List<MeterPO> selectMeterByImei(String imei){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        try {
            meterPOS = mapper.selectMeterByImei(imei);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPOS;
    }
    //根据楼号选择多台电表
    public List<MeterPO> selectMeterByBuilding(String community, String building){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPO = new ArrayList<MeterPO>();
        try {
            meterPO = mapper.selectMeterByBuilding(community, building);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPO;
    }
    //选择全部电表
    public List<MeterPO> selectAllMeter(String community){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPO = new ArrayList<MeterPO>();
        try {
            meterPO = mapper.selectAllMeter(community);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPO;
    }
    //查询所有楼号
    public List<String> selectAllBuilding(String community){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<String> building = new ArrayList<String>();
        try {
            building = mapper.selectAllBuilding(community);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return building;
    }
    //根据楼号查询所有房间
    public List<String> selectAllRoomByBuilding(String community, String building){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<String> room = new ArrayList<String>();
        try {
            room = mapper.selectAllRoomByBuilding(community, building);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return room;
    }

    public List<Integer> selectAllRelctiveLocationByImei(String imei) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<Integer> relativeLocationS = new ArrayList<Integer>();
        try {
            relativeLocationS = mapper.selectAllRelativeLocationByImei(imei);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return relativeLocationS;
    }

    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        try {
            meterPOS = mapper.selectMeterInfo(selectDataBO);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPOS;
    }

    public List<MeterClientPO> queryMeterClient(LocationBO locationBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterClientPO> meterPOS = new ArrayList<MeterClientPO>();
        try {
            meterPOS = mapper.queryForList(locationBO);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPOS;
    }

    //查询全部欠费用户
    public List<MeterClientPO> queryForArrearage(String community){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterClientPO> meterPOS = new ArrayList<MeterClientPO>();
        try {
            meterPOS = mapper.queryForArrearage(community);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterPOS;
    }
    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterStatusVO> meterStatusVOS = new ArrayList<MeterStatusVO>();
        try {
            meterStatusVOS = mapper.selectListMeter(locationBOS);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return meterStatusVOS;
    }

    public List<LocationBO> getAllMeter(String community){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<LocationBO> locationBOS = new ArrayList<LocationBO>();
        try {
            locationBOS = mapper.getMeterLocation(community);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return locationBOS;
    }
}
