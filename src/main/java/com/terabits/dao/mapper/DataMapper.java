package com.terabits.dao.mapper;

import com.terabits.meta.bo.DataBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.DataPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface DataMapper {

    /**
     * 新增map形式电表数据
     * @param params
     * @return
     * @throws Exception
     */
    public int insertData(Map<String,Object> params);

    /**
     * 根据条件删除电表数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public int deleteData(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据条件查询电表数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public List<DataPO> selectData(SelectDataBO selectDataBO) throws Exception;

    /**
     * 查询全部电表数据
     * @return
     * @throws Exception
     */
    public List<DataPO> selectAllData(@Param("community") String community, @Param("tableName") String tableName) throws Exception;

    /**
     * 新建数据表
     * @return
     * @throws Exception
     */
    int createNewTable(@Param("community") String community, @Param("tableName") String tableName) throws Exception;


    /**
     * 查询当前最后一条数据
     * @param tableName
     * @param time
     * @return
     * @throws Exception
     */
    public List<TempBusinessDataBO> selectMaxMeterData(@Param("community") String community, @Param("tableName") String tableName, @Param("time") String time);

    /**
     * 查询当前第一条数据
     * @param tableName
     * @param time
     * @return
     * @throws Exception
     */
    public List<TempBusinessDataBO> selectMinMeterData(@Param("community") String community, @Param("tableName") String tableName, @Param("time") String time);

}
