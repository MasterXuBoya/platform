package com.terabits.task;

import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.HomeChartPO;
import com.terabits.service.BusinessService;
import com.terabits.service.CommunityService;
import com.terabits.service.HomeChartService;
import com.terabits.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/6/1.
 */
@Component
@Transactional
public class TaskTest {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private HomeChartService homeChartService;
    @Autowired
    private CommunityService communityService;

    @SuppressWarnings("static-access")
	@Scheduled(cron = "0 0 0/1 * * *")
        //每隔1个小时，计算这个小时的总用电量，并存入redis；redis中不存在的时候是add，redis中存在的时候是update
    void calculateHourlyPower() throws Exception{
        TimeSpanBO timeSpanBO = TimeUtil.getTimeSpan();
        //获取当前时间的最后一条businessmeterdata数据
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        List<String> communityS = communityService.getAllCommunity();
        for (String community : communityS) {
	        BusinessMeterDataPO businessMeterDataPO = businessService.selectHourlyLastData(community, dfs.format(date));
	        double powerend = businessMeterDataPO.getPower();
	        System.out.println("powerend:" + powerend);
	        //获取1小时前的最后一条businessmeterdata数据
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(calendar.HOUR, -1);
	        Date begin = calendar.getTime();
	        BusinessMeterDataPO businessMeterDataPO1 = businessService.selectHourlyLastData(community, dfs.format(begin));
	        double powerbegin = businessMeterDataPO1.getPower();
	        System.out.println("powerbegin:" + powerbegin);
	        //二者相减，就是这一小时的电量数据
	        double power = powerend - powerbegin;
	        String timeId = timeSpanBO.getEndTime().substring(11, 13);
	        if (timeId.substring(0, 1).equals("0")) {
	            timeId = timeId.substring(1);
	        }
	        HomeChartPO homeChartPO = new HomeChartPO();
	        homeChartPO.setTimeId(Integer.parseInt(timeId));
	        homeChartPO.setElectricity(power);
	        homeChartPO.setCommunity(community);
	        homeChartService.updateHomeChartData(homeChartPO);
        }
    }

}
