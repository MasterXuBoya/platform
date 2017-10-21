package com.terabits.service;

import com.terabits.meta.po.HomeChartPO;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by liang on 2017/7/21.
 */
public interface HomeChartService {
    public int updateHomeChartData(HomeChartPO homeChartPO) throws Exception;

    public JSONArray getHomeChartData(String community, String dayBegin) throws Exception;

}
