package com.terabits.service;

import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.PaymentPO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface PaymentService {

    //插入缴费数据
    public int insertPayment(PaymentPO paymentPO);

    //删除缴费数据
    public int deletePayment(SelectDataBO selectDataBO);

    //根据条件查询缴费数据
    public List<PaymentPO> selectPayment(SelectDataBO selectDataBO);

    //求当日缴费数据和
    public int selectSumPayment(String community, String time);

    //查询当日交易笔数
    public int getPaymentCount(SelectDataBO selectDataBO);
}
