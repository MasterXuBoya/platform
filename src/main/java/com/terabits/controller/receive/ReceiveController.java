package com.terabits.controller.receive;

import com.terabits.iotconnetion.CodecComponent;
import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.bo.ReceiveDataBO;
import com.terabits.meta.po.AlarmPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.AlarmService;
import com.terabits.service.DataService;
import com.terabits.service.MeterService;
import com.terabits.service.TerminalService;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class ReceiveController {
    @Autowired
    private DataService dataService;
    @Autowired
    private MeterService meterService;
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private AlarmService alarmService;

    @SuppressWarnings("unchecked")
    //对华为lot platform上传命令进行处理，此处是被动处理，先接收数据，再返回信息
	@RequestMapping(value = "/receive/data", method = RequestMethod.POST)
    public void data(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        System.out.println(wholeStr);
        JSONObject json = JSONObject.fromObject(wholeStr);
        Map<String, Object> map = (Map<String, Object>)json;
        String terminalId = (String) map.get("deviceId");
        Map<String, Object> service = (Map<String, Object>)map.get("service");
        //data是Json对象
        Map<String, Object> data = (Map<String, Object>)service.get("data");

        int type = (Integer) data.get("type");
        //将接收到的数据存储到data_yuantong_01表中，此表名为自动生成
        if (type == CodecComponent.RECEIVE_DATA) {
            int meterRelativeLocation = (Integer) data.get("meterId");
            double power = Double.valueOf(data.get("power").toString());
            double voltage = Double.valueOf(data.get("voltage").toString());
            double current = Double.valueOf(data.get("current").toString());
            ReceiveDataBO receiveDataBO = new ReceiveDataBO();
            receiveDataBO.setTerminalId(terminalId);
            receiveDataBO.setMeterRelativeLocation(meterRelativeLocation);
            receiveDataBO.setCurrent(current);
            receiveDataBO.setPower(power);
            receiveDataBO.setVoltage(voltage);
            dataService.dataInsert(receiveDataBO);
        } else if (type == CodecComponent.TERMINAL_ONLINE) {
        	
        } else if (type == CodecComponent.TERMINAL_INFORMATION) {
            String info = (String)data.get("terminalState");
            byte [] rawInfo = new byte[info.length()];
            for (int i = 0; i < info.length(); i++) {
                rawInfo[i] = (byte) info.charAt(i);
            }
            if (rawInfo[0] == CodecComponent.REPLY_ADDRESS_ADD || rawInfo[0] == CodecComponent.REPLY_ADDRESS_REMOVED) {
            	replyAddressCommand(rawInfo, terminalId);
            } else if (rawInfo[0] == CodecComponent.REPLY_STOP_COMMAND) {
            	replyStopCommand(rawInfo, terminalId);
            } else if (rawInfo[0] == CodecComponent.REPLY_FREQUENCY) {
            	replyFrequency(rawInfo, terminalId);
            } else if (rawInfo[0] == CodecComponent.TERMINAL_ALARM) {
            	terminalAlarm(rawInfo, terminalId);
            } 
        }
    }

    public void replyAddressCommand(byte[] rawInfo, String terminalId) {
    	byte [] locationPicked = new byte[32];
		for (int i = 7; i >= 0; i--) {  
			locationPicked[i] = (byte)(rawInfo[1] & 1);  
			rawInfo[1] = (byte) (rawInfo[1] >> 1);  
        }
		for (int i = 15; i >= 8; i--) {  
			locationPicked[i] = (byte)(rawInfo[2] & 1);  
			rawInfo[2] = (byte) (rawInfo[2] >> 1);  
        }
		for (int i = 23; i >= 16; i--) {  
			locationPicked[i] = (byte)(rawInfo[3] & 1);  
			rawInfo[3] = (byte) (rawInfo[3] >> 1);  
        }
		for (int i = 31; i >= 24; i--) {  
			locationPicked[i] = (byte)(rawInfo[4] & 1);  
			rawInfo[4] = (byte) (rawInfo[4] >> 1);  
        }
		
		for (int i = 0; i < 32; i++) {
			if (locationPicked[i] == 1) {
				switch (rawInfo[0]) {
				case CodecComponent.REPLY_ADDRESS_ADD: meterService.setMeterState(terminalId, 32 - i, 1); break;
				case CodecComponent.REPLY_ADDRESS_REMOVED: meterService.setMeterState(terminalId, 32 - i, 3); break;
				}
			}
		}
    }
    
    public void replyStopCommand(byte[] rawInfo, String terminalId) {
        for (int i = 1; i < rawInfo.length; i = i + 2) {
            int meterId = rawInfo[i] / 16 * 10 + rawInfo[i] % 16;
            if (meterId == 0) {
            	return;
            }
            int meterState = rawInfo[i + 1];
            if (meterState == CodecComponent.METER_STATE_OFF) {
                meterService.setMeterState(terminalId, meterId, 2);
            } else if (meterState == CodecComponent.METER_STATE_ON) {
                meterService.setMeterState(terminalId, meterId, 1);
            }
        }
    }
    
    public void replyFrequency(byte[] rawInfo, String terminalId) {
    	TerminalPO terminalPO = terminalService.getTerminalByTerminalId(terminalId);
    	if (terminalPO.getFrequencyHeart() != -1) {
    		return;
    	}
    	FrequencyBO frequencyBO = new FrequencyBO();
    	frequencyBO.setFrequencyHeart(0);
    	frequencyBO.setFrequencyTask(0);
    	frequencyBO.setImei(terminalPO.getTerminalImei());
    	try {
			terminalService.updateFrequency(frequencyBO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
   
    public void terminalAlarm(byte[] rawInfo, String terminalId) {
    	TerminalPO terminalPO = terminalService.getTerminalByTerminalId(terminalId);
    	AlarmPO alarmPO = new AlarmPO();
		alarmPO.setAlarmInfo("终端：" + terminalPO.getTerminalImei() + "掉电。");
		alarmPO.setAlarmType(0);
		alarmPO.setTerminalImei(terminalPO.getTerminalImei());
		alarmPO.setCommunity(terminalPO.getCommunity());
		alarmService.insertAlarm(alarmPO);
    } 
}
