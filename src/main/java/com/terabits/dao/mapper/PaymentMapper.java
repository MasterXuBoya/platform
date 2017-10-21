package com.terabits.dao.mapper;

import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.PaymentPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface PaymentMapper {

    /**
     * 新增缴费数据
     * @param paymentPO
     * @return
     * @throws Exception
     */
    public int insertPayment(PaymentPO paymentPO) throws Exception;

    /**
     * 根据条件删除缴费数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public int deletePayment(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据条件查询缴费数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public List<PaymentPO> selectPayment(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据openId查询缴费数据
     * @return
     * @throws Exception
     */
    public List<PaymentPO> selectPaymentByOpenId(@Param("openId")String openId) throws Exception;

    /**
     * 查询全部缴费数据
     * @return
     * @throws Exception
     */
    public List<PaymentPO> selectAllPayment(@Param("community") String community) throws Exception;

    /**
     * 根据24小时缴费数据之和
     * @return
     * @throws Exception
     */
    public int selectSumPayment(@Param("community") String community, @Param("time")String time) throws Exception;

    /**
     * 根据条件查询缴费数量
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public int selectCountByTime(SelectDataBO selectDataBO) throws Exception;


}
