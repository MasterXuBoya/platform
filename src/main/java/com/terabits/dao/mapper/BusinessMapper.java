package com.terabits.dao.mapper;

import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface BusinessMapper {


    /**
     * 新增24小时电表数据
     *
     * @return
     * @throws Exception
     */
    public int insertBusinessMeterData(BusinessMeterDataPO businessMeterDataPO) throws Exception;

    /**
     * 新增24小时缴费数据
     *
     * @return
     * @throws Exception
     */
    public int insertBusinessPaymentData(BusinessPaymentPO businessPaymentPO) throws Exception;

    /**
     * 查询24小时电表数据
     *
     * @return
     * @throws Exception
     */
    public BusinessMeterDataPO selectBusinessMeterData(@Param("community") String community, @Param("time") String time) throws Exception;

    /**
     * 查询24小时缴费数据
     *
     * @return
     * @throws Exception
     */
    public BusinessPaymentPO selectBusinessPaymentData(@Param("community") String community, @Param("time") String time) throws Exception;

    /**
     * 查询每小时最后一条数据
     *
     * @return
     * @throws Exception
     */
    public BusinessMeterDataPO selectHourlyLastData(@Param("community") String community, @Param("time") String time) throws Exception;

}
