package com.terabits.service.impl;

import com.terabits.dao.HomeChartDao;
import com.terabits.meta.po.HomeChartPO;
import com.terabits.service.HomeChartService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2017/7/21.
 */
@Service
public class HomeChartServiceImpl implements HomeChartService {

    @Autowired
    private HomeChartDao homeChartDao;

    public int updateHomeChartData(HomeChartPO homeChartPO) throws Exception {
        int flag;
        flag = homeChartDao.updateData(homeChartPO);
        return flag;
    }

    public JSONArray getHomeChartData(String community, String dayBegin) throws Exception {
        List<HomeChartPO> homeChartPOS = homeChartDao.getData(community, dayBegin);
        JSONArray homeChartDataList = JSONArray.fromObject(homeChartPOS);
        return homeChartDataList;
    }
}
