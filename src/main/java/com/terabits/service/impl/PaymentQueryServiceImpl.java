package com.terabits.service.impl;

import com.terabits.meta.bo.ClientInfoBO;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.PaymentPO;
import com.terabits.meta.vo.ClientInfoVO;
import com.terabits.meta.vo.PaymentVO;
import com.terabits.service.*;
import com.terabits.utils.GenerateOrderId;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
@Transactional
@Service("paymentQueryService")
public class PaymentQueryServiceImpl implements PaymentQueryService {
    @Autowired
    private MeterService meterService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private ClientInfoService clientInfoService;
    public JSONArray queryRemain(String community, String building, String room){
        LocationBO locationBO = new LocationBO();
        locationBO.setCommunity(community);
        if(!building.equals("all")){
            locationBO.setBuilding(building);
        }
        if(!room.equals("all")){
            locationBO.setRoom(room);
        }
        System.out.println(locationBO);
        List<MeterClientPO> meterClientPOS= meterService.queryMeterClient(locationBO);
        JSONArray jsonArray = new JSONArray();
        for (MeterClientPO meterClientPO : meterClientPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("room", meterClientPO.getRoom());
            jsonObject.put("building", meterClientPO.getBuilding());
            jsonObject.put("remain", meterClientPO.getRemain());
            ClientInfoBO clientInfoBO = new ClientInfoBO();
            clientInfoBO = meterClientPO.getClients().get(0);
            jsonObject.put("name", clientInfoBO.getName());
            jsonObject.put("phone", clientInfoBO.getPhone());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public List<PaymentVO> queryPayment(String community, String building, String room, String begin, String end){
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setCommunity(community);
        if(!building.equals("all")){
            selectDataBO.setBuilding(building);
        }
        if(!room.equals("all")){
            selectDataBO.setRoom(room);
        }
        if(begin != "null"){
            selectDataBO.setBeginTime(begin);
        }
        if(end != "null"){
            selectDataBO.setEndTime(end);
        }
        List<PaymentPO> paymentPOS = paymentService.selectPayment(selectDataBO);
        List<PaymentVO> paymentVOS = new ArrayList<PaymentVO>();
        for(int i = 0; i < paymentPOS.size(); i++){
            PaymentVO paymentVO = new PaymentVO();
            paymentVO.setBuilding(paymentPOS.get(i).getBuilding());
            paymentVO.setRoom(paymentPOS.get(i).getRoom());
            paymentVO.setPayment(paymentPOS.get(i).getPayment());
            paymentVO.setRemain(paymentPOS.get(i).getRemaining());
            paymentVO.setTime(paymentPOS.get(i).getGmtCreate());
            paymentVOS.add(paymentVO);
        }
        return paymentVOS;
    }
    public int munualDeposit(String community, String building, String room, String money){
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBuilding(building);
        selectDataBO.setRoom(room);
        selectDataBO.setCommunity(community);
        MeterPO meterPO = meterService.selectMeterInfo(selectDataBO).get(0);
        double remain = Double.parseDouble(money) + meterPO.getMeterRemain();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String begin = dfs.format(date) + " 00:00:00";
        SelectDataBO selectDataBO1 = new SelectDataBO();
        selectDataBO1.setBeginTime(begin);
        selectDataBO1.setCommunity(community);
        int count = paymentService.getPaymentCount(selectDataBO1) + 1;
        String tradeNo = GenerateOrderId.generateOrderId(count);
        PaymentPO paymentPO = new PaymentPO();
        paymentPO.setRemaining(remain);
        paymentPO.setPayment(Integer.parseInt(money));
        paymentPO.setTradeNo(tradeNo);
        paymentPO.setBuilding(building);
        paymentPO.setRoom(room);
        paymentPO.setCommunity(community);
        //paymentPO.setOpenId("003");
        //paymentPO.setOrderId(tradeNo);
        paymentPO.setOperatorId("003");
        int result1 = paymentService.insertPayment(paymentPO);
        int result2 = meterService.updateMeterRemain(community, remain, building, room);
        return result1 + result2;
    }

    public void feeReminder(String building, String room){
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBuilding(building);
        selectDataBO.setRoom(room);
        ClientInfoPO clientInfoPO = clientInfoService.selectClient(selectDataBO).get(2);
        MeterPO meterPO = meterService.selectMeterInfo(selectDataBO).get(0);
        String openId = clientInfoPO.getOpenId();
        String name = clientInfoPO.getName();
        double balance = meterPO.getMeterRemain();
        templateService.feeReminder(openId, name, Double.toString(balance));
    }

    public JSONArray arrearage(String community){
        List<MeterClientPO> meterClientPOS= meterService.queryForArrearage(community);
        JSONArray jsonArray = new JSONArray();
        for (MeterClientPO meterClientPO : meterClientPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("room", meterClientPO.getRoom());
            jsonObject.put("building", meterClientPO.getBuilding());
            jsonObject.put("remain", meterClientPO.getRemain());
            ClientInfoBO clientInfoBO = new ClientInfoBO();
            clientInfoBO = meterClientPO.getClients().get(0);
            jsonObject.put("name", clientInfoBO.getName());
            jsonObject.put("phone", clientInfoBO.getPhone());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

}
