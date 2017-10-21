package com.terabits.task;

import java.text.SimpleDateFormat;

import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;
import com.terabits.service.DataService;
import com.terabits.service.MeterService;
import com.terabits.service.BusinessService;
import com.terabits.service.CommunityService;
import com.terabits.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class BusinessDataTask {
    @Autowired
    private DataService dataService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private MeterService meterService;
    
    @Scheduled(cron = "0 0/15 * * * *")
    //每隔15分钟计算一次当日使用总电量和当日缴费总和，存入businessmeterdata和businesspayment表中
    void calculateSum(){
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dfsCurrent = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = new Date();
        Date currentTime = new Date();
        String time11 = dfs.format(time1);
        List<String> communityS = communityService.getAllCommunity();
        for (String community : communityS) {
	        String currentQueryTime = dfsCurrent.format(currentTime) + " 00:00:00";
	        List<TempBusinessDataBO> sumMaxDataBOList = new ArrayList<TempBusinessDataBO>();
	        List<TempBusinessDataBO> sumMinDataBOList = new ArrayList<TempBusinessDataBO>();
	        //遍历当前全部数据表，获取当日用电量数据
	        List<String> buildingS = meterService.queryBuilding(community);
	        for(String building : buildingS) {
	            String tableName = "data_" + community + "_" + building;
	            List<TempBusinessDataBO> MaxDataBOList = dataService.selectMaxMeterData(community, tableName, currentQueryTime);
	            sumMaxDataBOList.addAll(MaxDataBOList);
	            List<TempBusinessDataBO> MinDataBOList = dataService.selectMinMeterData(community, tableName, currentQueryTime);
	            sumMinDataBOList.addAll(MinDataBOList);
	        }
	        Double sum1 = 0.0;
	        Double sum2 = 0.0;
	        for(int i = 0; i< sumMaxDataBOList.size();i++) {
	            sum1 += sumMaxDataBOList.get(i).getTempPower();
	            sum2 += sumMinDataBOList.get(i).getTempPower();
	        }
	        Double power = sum1 - sum2;
	        BusinessMeterDataPO businessMeterDataPO = new BusinessMeterDataPO();
	        businessMeterDataPO.setPower(power);
	        businessMeterDataPO.setCommunity(community);
	        businessService.insertBusinessMeterData(businessMeterDataPO);
	        int payment = paymentService.selectSumPayment(community, currentQueryTime);
	        BusinessPaymentPO businessPaymentPO = new BusinessPaymentPO();
	        businessPaymentPO.setPayment(payment);
	        businessPaymentPO.setCommunity(community);
	        businessService.insertBusinessPaymentData(businessPaymentPO);
        }
        System.out.println("I'm doing with cron now!" + time11);
    }

}
