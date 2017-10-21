package com.terabits.dao;

import com.terabits.dao.mapper.BusinessMapper;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.sql.Time;

/**
 * Created by Administrator on 2017/6/14.
 */
@Repository("businessDao")
public class BusinessDao {

    //新增24小时电表数据
    public int insertBusinessMeterData(BusinessMeterDataPO businessMeterDataPO) {
        SqlSession session = DBTools.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        try {
            mapper.insertBusinessMeterData(businessMeterDataPO);
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

    //新增24小时缴费数据
    public int insertBusinessPaymentData(BusinessPaymentPO businessPaymentPO) {
        SqlSession session = DBTools.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        try {
            mapper.insertBusinessPaymentData(businessPaymentPO);
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


    // 查询24小时电表数据
    public BusinessMeterDataPO selectBusinessMeterData(String community, String time){
        SqlSession session = DBTools.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        BusinessMeterDataPO businessMeterDataPO = new BusinessMeterDataPO();
        try {
            businessMeterDataPO = mapper.selectBusinessMeterData(community, time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return businessMeterDataPO;
    }

    //查询24小时缴费数据

    public BusinessPaymentPO selectBusinessPaymentData(String community, String time){
        SqlSession session = DBTools.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        BusinessPaymentPO businessPaymentPO = new BusinessPaymentPO();
        try {
            businessPaymentPO = mapper.selectBusinessPaymentData(community, time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return businessPaymentPO;

    }

    public BusinessMeterDataPO selectHourlyLastData(String community, String time){
        SqlSession session = DBTools.getSession();
        BusinessMapper mapper = session.getMapper(BusinessMapper.class);
        BusinessMeterDataPO businessMeterDataPO = new BusinessMeterDataPO();
        try {
            businessMeterDataPO = mapper.selectHourlyLastData(community, time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return businessMeterDataPO;
    }
}