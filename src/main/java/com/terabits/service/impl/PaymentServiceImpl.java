package com.terabits.service.impl;

import com.terabits.dao.PaymentDao;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.PaymentPO;
import com.terabits.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2017/6/15.
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDao paymentDao;
    public int insertPayment(PaymentPO paymentPO){
        int result = paymentDao.insertPayment(paymentPO);
        return result;
    }

    public int deletePayment(SelectDataBO selectDataBO){
        int result = paymentDao.deletePayment(selectDataBO);
        return result;
    }

    //根据条件查询缴费数据
    public List<PaymentPO> selectPayment(SelectDataBO selectDataBO){
        List<PaymentPO> paymentPOS = paymentDao.selectPayment(selectDataBO);
        return paymentPOS;
    }

    public int selectSumPayment(String community, String time){
        int payment = paymentDao.selectSumPayment(community, time);
        return payment;
    }

    public int getPaymentCount(SelectDataBO selectDataBO){
        int count = paymentDao.selectCountByTime(selectDataBO);
        return count;
    }

}
