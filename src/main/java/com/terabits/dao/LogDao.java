package com.terabits.dao;

import com.terabits.dao.mapper.LogMapper;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TimeSpanAndCommunityBO;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.LogPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository("logDao")
/**
 * Created by Administrator on 2017/5/26.
 */
public class LogDao{

 /*   public static void main(String args[]){
      SelectDataBO selectDataBO = new SelectDataBO();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = "2017-05-26 16:58:18";
        String time2 = "2017-05-26 17:00:14";
        Date time11 = new Date();
        Date time21 = new Date();
        try {
            time11 = dfs.parse(time1);
            time21 = dfs.parse(time2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        selectDataBO.setBeginTime(time11.getTime()/1000);
        selectDataBO.setEndTime(time21.getTime()/1000);
        selectDataBO.setType("data");
        System.out.println(selectLog(selectDataBO));
    }*/

    //新增日志数据
    public int insertLog(LogPO logPO) {
        SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        try {
            mapper.insertLog(logPO);
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

    //根据类型删除日志

    public int delectLogByType(String community, String logType) {
        SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        try {
            mapper.deleteLogByType(community, logType);
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

    //根据时间段删除日志
    public int delectLogByTime(TimeSpanAndCommunityBO timeSpanAndCommunityBO) {
        SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        try {
            mapper.deleteLogByTime(timeSpanAndCommunityBO);
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


    //根据条件查询告警数据
    public List<LogPO> selectLog(TimeSpanAndCommunityBO timeSpanAndCommunityBO){
        SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        List<LogPO> logPOS = new ArrayList<LogPO>();
        try {
            logPOS = mapper.selectLog(timeSpanAndCommunityBO);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
        	session.close();
        }
        return logPOS;
    }

    //查询全部告警数据
    public List<LogPO> selectAllLog(String community){
        SqlSession session = DBTools.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        List<LogPO> logPOS = new ArrayList<LogPO>();
        try {
            logPOS = mapper.selectAllLog(community);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return logPOS;
    }
}
