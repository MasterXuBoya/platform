package com.terabits.dao;

import com.terabits.dao.mapper.AlarmMapper;

import com.terabits.meta.bo.TimeSpanAndCommunityBO;

import com.terabits.meta.po.AlarmPO;

import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository("alarmDao")
public class AlarmDao {
   /* public static void main(String args[]){
        TimeSpanBO timeSpanBO = new TimeSpanBO();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AlarmPO alarmPO = new AlarmPO();
        alarmPO.setTerminalImei("863703030057025");
        alarmPO.setAlarmInfo("终端电压不稳");
        alarmPO.setAlarmType(0);
        alarmPO.setBuilding("01");
        alarmPO.setRoom("102");
        insertAlarm(alarmPO);
    }
*/
    //新增告警数据
    public int insertAlarm(AlarmPO alarmPO) {
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.insertAlarm(alarmPO);
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

    //根据楼号和室号删除告警数据
    public int deleteAlarmByRoom(String community, String building, String room){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.deleteAlarmByRoom(community, building, room);
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

    // 根据时间段删除告警数据
    public int deleteAlarmByTime(TimeSpanAndCommunityBO timeSpanAndCommunityBO){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.deleteAlarmByTime(timeSpanAndCommunityBO);
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

    //根据时间段查询告警数据
    public List<AlarmPO> selectAlarmByTime(TimeSpanAndCommunityBO timeSpanAndCommunityBO){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        List<AlarmPO> alarmPOS = new ArrayList<AlarmPO>();
        try {
            alarmPOS = mapper.selectAlarmByTime(timeSpanAndCommunityBO);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
        	session.close();
        }
        return alarmPOS;
    }

    //查询所有的告警数据
    public List<AlarmPO> selectAllAlarm(String community){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        List<AlarmPO> alarmPOS = new ArrayList<AlarmPO>();
        try {
            alarmPOS = mapper.selectAllAlarm(community);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
        	session.close();
        }
        return alarmPOS;
    }

    //查询当日告警数据和
    public int getSumAlarm(String community, String time){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        int sumAlarm = 0;
        try{
            sumAlarm = mapper.selectSumAlarm(community, time);
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return sumAlarm;
    }
}
