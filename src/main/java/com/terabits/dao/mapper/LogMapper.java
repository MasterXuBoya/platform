package com.terabits.dao.mapper;

import com.terabits.meta.bo.TimeSpanAndCommunityBO;
import com.terabits.meta.po.LogPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface LogMapper {
    /**
     * 新增日志数据
     * @param logPO
     * @return
     * @throws Exception
     */
    public int insertLog(LogPO logPO) throws Exception;

    /**
     * 根据类型删除日志
     * @return
     * @throws Exception
     */
    public int deleteLogByType(@Param("community")String community, @Param("logType")String logType) throws Exception;

    /**
     * 根据时间段删除日志
     * @return
     * @throws Exception
     */
    public int deleteLogByTime(@Param("timeSpanAndCommunityBO")TimeSpanAndCommunityBO timeSpanAndCommunityBO) throws Exception;


    /**
     * 根据条件查询日志
     * @return
     * @throws Exception
     */
    public List<LogPO> selectLog(TimeSpanAndCommunityBO timeSpanAndCommunityBO) throws Exception;

    /**
     * 查询所有日志
     * @return
     * @throws Exception
     */
    public List<LogPO> selectAllLog(@Param("community")String community) throws Exception;

}
