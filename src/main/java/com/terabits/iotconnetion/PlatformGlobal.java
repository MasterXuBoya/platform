package com.terabits.iotconnetion;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Administrator on 2017/5/27.
 */
public class PlatformGlobal {
    public static int limitDevicesByOneTerminal = 32;

    public static String appId = "u8tbdlefBCUXxlxR2mri4Sn3rGca";
    public static String secret = "hsI01snvRN8v102kOFLMPTwWHPUa";

    public static String urlLogin = "https://112.17.33.73:8743/iocm/app/sec/v1.1.0/login";
    public static String urlReg = "https://112.17.33.73:8743/iocm/app/reg/v1.2.0/devices";
    public static String urlSetDeviceInfo = "https://112.17.33.73:8743/iocm/app/dm/v1.2.0/devices/";
    public static String urlDelete = "https://112.17.33.73:8743/iocm/app/dm/v1.1.0/devices/";
    public static String urlPostAsynCmd = "https://112.17.33.73:8743/iocm/app/cmd/v1.2.0/devices/%s/commands";

    public static String manufacturerId= "terabits";
    public static String manufacturerName = "terabits";
    public static String deviceType = "ElectricityDevice";
    public static String protocolType = "CoAP";
    public static String model = "001";
    public static String serviceId = "ElectricityService";
    public static String callbackUrl = "http://112.124.6.31:8080/NBReceiver/test";
    public static int expireTime = 0;

    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        Map<String, String> paramLogin = new HashMap<String, String>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        String bodyLogin = httpsUtil.doPostFormUrlEncodedForString(urlLogin,
                paramLogin);
        System.out.println(bodyLogin);

        Map<String, String> data = new HashMap<String, String>();
        data = JsonUtil.jsonString2SimpleObj(bodyLogin, data.getClass());
        String accessToken = data.get("accessToken");
        return accessToken;
    }

    public static String command(byte[] data, String terminalId) throws Exception{
    	System.out.println(terminalId);
    	String a = "";
    	for (int i = 0; i < data.length; i++) {
    		a += byteToHexString(data[i]);
    	}
    	System.out.println(a);
    	
        String command = Base64.encodeBase64String(data);

        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = login(httpsUtil);
        urlPostAsynCmd = String.format(urlPostAsynCmd, terminalId);

        String method = "START";
        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"rawData\":\"" + command +"\"}");

        Map<String, Object> paramCommand = new HashMap<String, Object>();
        paramCommand.put("serviceId", "RawData");
        paramCommand.put("method", method);
        paramCommand.put("paras", paras);

        Map<String, Object> paramPostAsynCmd = new HashMap<String, Object>();
        paramPostAsynCmd.put("command", paramCommand);
        //paramPostAsynCmd.put("callbackUrl", callbackUrl);
        paramPostAsynCmd.put("expireTime",expireTime);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramPostAsynCmd);

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", appId);
        header.put("Authorization", "Bearer " + accessToken);

        HttpResponse httpResponse = httpsUtil.doPostJson(urlPostAsynCmd, header, jsonRequest);

        String responseBody = httpsUtil.getHttpResponseBody(httpResponse);

        return responseBody;
    }

    public static String command(String terminalId, String method, ObjectNode paras) throws Exception{

        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = login(httpsUtil);
        urlPostAsynCmd = String.format(urlPostAsynCmd, terminalId);

        Map<String, Object> paramCommand = new HashMap<String, Object>();
        paramCommand.put("serviceId", serviceId);
        paramCommand.put("method", method);
        paramCommand.put("paras", paras);

        System.out.println("deviceID: " + terminalId);
        System.out.println("serviceId: " + serviceId);
        System.out.println("method: " + method);
        System.out.println("paras: " + paras);

        Map<String, Object> paramPostAsynCmd = new HashMap<String, Object>();
        paramPostAsynCmd.put("command", paramCommand);
        //paramPostAsynCmd.put("callbackUrl", callbackUrl);
        paramPostAsynCmd.put("expireTime",expireTime);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramPostAsynCmd);

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", appId);
        header.put("Authorization", "Bearer " + accessToken);

        HttpResponse httpResponse = httpsUtil.doPostJson(urlPostAsynCmd, header, jsonRequest);

        String responseBody = httpsUtil.getHttpResponseBody(httpResponse);

        return responseBody;
    }
    
	public static String byteToHexString(byte src){
	    StringBuilder stringBuilder = new StringBuilder("");
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
	    return stringBuilder.toString();
	}
}

