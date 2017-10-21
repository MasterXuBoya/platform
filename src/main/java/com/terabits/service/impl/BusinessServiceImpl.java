package com.terabits.service.impl;

import com.terabits.dao.BusinessDao;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;
import com.terabits.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessDao businessDao;
    //新增24小时电表数据
    public int insertBusinessMeterData(BusinessMeterDataPO businessMeterDataPO){
        int result = businessDao.insertBusinessMeterData(businessMeterDataPO);
        return result;
    }

    //新增24小时缴费数据
    public int insertBusinessPaymentData(BusinessPaymentPO businessPaymentPO) {
        int result = businessDao.insertBusinessPaymentData(businessPaymentPO);
        return result;
    }

    // 查询24小时电表数据
    public BusinessMeterDataPO selectBusinessMeterData(String community, String time){
        BusinessMeterDataPO businessMeterDataPO = businessDao.selectBusinessMeterData(community, time);
        return businessMeterDataPO;
    }

    //查询24小时缴费数据
    public BusinessPaymentPO selectBusinessPaymentData(String community, String time) {
        BusinessPaymentPO businessPaymentPO = businessDao.selectBusinessPaymentData(community, time);
        return businessPaymentPO;
    }

    public BusinessMeterDataPO selectHourlyLastData(String community, String time){
        BusinessMeterDataPO businessMeterDataPO = businessDao.selectHourlyLastData(community, time);
        return businessMeterDataPO;
    }
}
