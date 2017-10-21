package com.terabits.dao.mapper;

import com.terabits.meta.po.HomeChartPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liang on 2017/7/21.
 */
public interface HomeChartMapper {
    /**
     * 增加运算后的表格记录
     * @return
     * @throws Exception
     */
    public int updateData(HomeChartPO homeChartPO) throws Exception;

    /**
     * 更新运算后的表格记录
     * @return
     * @throws Exception
     */
    public List<HomeChartPO> getData(@Param("community") String community ,@Param("dayBegin") String dayBegin) throws Exception;

}
