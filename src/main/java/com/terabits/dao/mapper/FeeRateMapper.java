package com.terabits.dao.mapper;

import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.StringTimeSpanBO;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.FeeRatePO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface FeeRateMapper {
     /**
     * 新增费率设置数据
     * @param feeRatePO
     * @return
     * @throws Exception
     */
    public int insertFeeRate(FeeRatePO feeRatePO) throws Exception;

    /**
     * 根据时间删除费率设置数据
     * @param timeSpanBO
     * @return
     * @throws Exception
     */
    public int deleteFeeRate(TimeSpanBO timeSpanBO) throws Exception;

    /**
     * 根据时间查询费率设置数据
     * @param timeSpanBO
     * @return
     * @throws Exception
     */
    public List<FeeRatePO> selectFeeRate(TimeSpanBO timeSpanBO) throws Exception;

    /**
     * 查询全部费率设置数据
     * @return
     * @throws Exception
     */
    public List<FeeRatePO> selectAllFeeRate() throws Exception;

}
