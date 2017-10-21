package com.terabits.dao;

import com.terabits.dao.mapper.PaymentMapper;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.PaymentPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Repository("paymentDao")
public class PaymentDao {

    //新增缴费数据
    public int insertPayment(PaymentPO paymentPO) {
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        try {
            mapper.insertPayment(paymentPO);
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

    //删除缴费数据
    public int deletePayment(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        try {
            mapper.deletePayment(selectDataBO);
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

    //根据条件查询缴费数据
    public List<PaymentPO> selectPayment(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectPayment(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return paymentPOS;
    }

    //根据openId查询缴费数据
    public List<PaymentPO> selectPaymentByOpenId(String openId){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectPaymentByOpenId(openId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return paymentPOS;
    }

    //查询全部缴费数据

    public List<PaymentPO> selectAllPayment(String community) {
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectAllPayment(community);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return paymentPOS;
    }

    public int selectSumPayment(String community, String time){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        int sumPayment = 0;
        try {
            sumPayment = mapper.selectSumPayment(community, time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return sumPayment;
    }

    //根据条件查询缴费数据量
    public int selectCountByTime(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        int count = 0;
        try {
            count = mapper.selectCountByTime(selectDataBO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	session.close();
        }
        return count;
    }

}
