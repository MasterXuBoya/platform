package com.terabits.dao;

import com.terabits.dao.mapper.DataMapper;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.DataPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository("buildingDao")
public class DataDao {

    //新增电表数据
    public int insertData(Map<String,Object> params) {
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        try {
            mapper.insertData(params);
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


    //根据条件删除电表数据
    public int deleteData(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        try {
            mapper.deleteData(selectDataBO);
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

    //根据条件查询电表数据
    public List<DataPO> selectData(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        List<DataPO> buildingPOS = new ArrayList<DataPO>();
        try {
            buildingPOS = mapper.selectData(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return buildingPOS;
    }

    //查询全部电表数据
    public List<DataPO> selectAllData(String community, String tableName) {
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        List<DataPO> buildingPOS = new ArrayList<DataPO>();
        try {
            buildingPOS = mapper.selectAllData(community, tableName);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return buildingPOS;
    }

    //根据需求新建数据表
    public int createNewTable(String community, String tableName){
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        try {
            mapper.createNewTable(community, tableName);
            session.commit();
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
    }

     //查询当前所有电表最后一条数据
    public List<TempBusinessDataBO> selectMaxMeterData(String community, String tableName, String time){
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        List<TempBusinessDataBO> tempBusinessDataBOS = new ArrayList<TempBusinessDataBO>();
        try {
            tempBusinessDataBOS = mapper.selectMaxMeterData(community, tableName, time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return tempBusinessDataBOS;
    }

    //查询当前所有电表第一条数据

    public List<TempBusinessDataBO> selectMinMeterData(String community, String tableName, String time){
        SqlSession session = DBTools.getSession();
        DataMapper mapper = session.getMapper(DataMapper.class);
        List<TempBusinessDataBO> tempBusinessDataBOS = new ArrayList<TempBusinessDataBO>();
        try {
            tempBusinessDataBOS = mapper.selectMinMeterData(community, tableName, time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return tempBusinessDataBOS;
    }

}
