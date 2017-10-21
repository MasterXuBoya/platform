package com.terabits.dao;

import com.terabits.dao.mapper.FeeRateMapper;
import com.terabits.meta.bo.StringTimeSpanBO;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.FeeRatePO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public class FeeRateDao {

    //新增费率设置数据
    public static int insertFeeRate(FeeRatePO feeRatePO){
        SqlSession session = DBTools.getSession();
        FeeRateMapper mapper = session.getMapper(FeeRateMapper.class);
        try {
            mapper.insertFeeRate(feeRatePO);
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

     //根据时间删除费率设置数据
    public int deleteFeeRate(TimeSpanBO timeSpanBO){
        SqlSession session = DBTools.getSession();
        FeeRateMapper mapper = session.getMapper(FeeRateMapper.class);
        try {
            mapper.deleteFeeRate(timeSpanBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //根据时间查询费率设置数据
    public static List<FeeRatePO> selectFeeRate(TimeSpanBO timeSpanBO){
        SqlSession session = DBTools.getSession();
        FeeRateMapper mapper = session.getMapper(FeeRateMapper.class);
        List<FeeRatePO> feeRatePOS = new ArrayList<FeeRatePO>();
        try {
            feeRatePOS = mapper.selectFeeRate(timeSpanBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return feeRatePOS;
    }
    // 查询全部费率设置数据
    public static List<FeeRatePO> selectAllFeeRate(){
        SqlSession session = DBTools.getSession();
        FeeRateMapper mapper = session.getMapper(FeeRateMapper.class);
        List<FeeRatePO> feeRatePOS = new ArrayList<FeeRatePO>();
        try {
            feeRatePOS = mapper.selectAllFeeRate();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return feeRatePOS;
    }
}
