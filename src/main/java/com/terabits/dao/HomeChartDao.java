package com.terabits.dao;

import com.terabits.dao.mapper.HomeChartMapper;
import com.terabits.meta.po.HomeChartPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liang on 2017/7/21.
 */
@Repository("homeChartDao")
public class HomeChartDao {

    public int updateData(HomeChartPO homeChartPO) throws Exception {
        SqlSession session = DBTools.getSession();
        HomeChartMapper mapper = session.getMapper(HomeChartMapper.class);
        try {
            mapper.updateData(homeChartPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 0;
        } finally {
            session.close();
        }
        return 1;
    }

    public List<HomeChartPO> getData(String community, String dayBegin) throws Exception {
        SqlSession session = DBTools.getSession();
        HomeChartMapper mapper = session.getMapper (HomeChartMapper.class);
        List<HomeChartPO> homeChartData = new ArrayList<HomeChartPO>();
        try {
            homeChartData = mapper.getData(community, dayBegin);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return homeChartData;
    }
}
