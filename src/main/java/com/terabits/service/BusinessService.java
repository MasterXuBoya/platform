package com.terabits.service;

import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface BusinessService {

    //新增24小时电表数据
    public int insertBusinessMeterData(BusinessMeterDataPO businessMeterDataPO);


    //新增24小时缴费数据
    public int insertBusinessPaymentData(BusinessPaymentPO businessPaymentPO);


    // 查询24小时电表数据
    public BusinessMeterDataPO selectBusinessMeterData(String community, String time);

    //查询24小时缴费数据
    public BusinessPaymentPO selectBusinessPaymentData(String community, String time);

    //获取每小时的最后一条数据，两条相减，获得每小时的数据
    public BusinessMeterDataPO selectHourlyLastData(String community, String time);
}
