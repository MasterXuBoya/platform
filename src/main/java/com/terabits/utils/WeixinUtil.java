package com.terabits.utils;


import com.terabits.constant.ProjectGlobal;
import com.terabits.meta.bo.TemplateBO;
import com.terabits.meta.bo.AccessTokenBO;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;

/**
 * Created by Administrator on 2017/4/28.
 */
public class WeixinUtil {
    // 获取access_token的接口地址（GET） 限200（次/天）
    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);
    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        String data = "";
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            //jsonObject = JSONObject.fromObject(buffer.toString());
            data = buffer.toString();
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return data;
    }
    /**
     * 获取access_token
     *
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public final static String send_template_url ="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    public static AccessTokenBO getAccessToken(String appid, String appsecret) {
        AccessTokenBO accessToken = null;

        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        String data  = httpRequest(requestUrl, "GET", null);
        JSONObject jsonObject = jsonObject = JSONObject.fromObject(data);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessTokenBO();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }

    public static String getOpenid(HttpSession session, String appId, String appSecret){
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String requestUrl = o_auth_openid_url.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", (String)session.getAttribute("code"));
        String data = httpRequest(requestUrl, "GET", null);
        JSONObject jsonObject = JSONObject.fromObject(data);
        String openId = "";
        //oAuthInfo是作者自己把那几个属性参数写在一个类里面了。
        // 如果请求成功
        if (null != jsonObject) {
            try {
                openId = jsonObject.getString("openid");
            } catch (JSONException e) {
                // 获取token失败
                log.error("网页授权获取openId失败 errcode:{} errmsg:{}", jsonObject
                        .getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return openId;
    }

    private static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getJsapiTicket(String accessToken)
    {
        String jsapiTicket = null;
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        String data = httpRequest(requestUrl, "GET", null);
        JSONObject jsonObject = JSONObject.fromObject(data);
        if (null != jsonObject)
        {
            try
            {
                jsapiTicket = jsonObject.getString("ticket");
            }
            catch (Exception e)
            {
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
            }
        }
        return jsapiTicket;
    }

    /**
     * 发送模板消息
     * @param t
     * @param accessToken
     * @return
     */
    public static int sendMessage(TemplateBO t, String accessToken) {
        int result = 0;
        // 拼装发送模板消息的url
        String url = send_template_url.replace("ACCESS_TOKEN", accessToken);
        // 将模板消息转换成json字符串
        String jsonMenu = JSONObject.fromObject(t).toString();
        // 调用接口创建模板消息
        String requestmES ="{\"data\":{\"first\": {\"keyword1\":{\"value\":\"巧克力\",\"color\":\"#173177\"},\"value\":\"亲爱的张小姐，您2017年5月的电费单还未支付！\",\"color\":\"#173177\"},\"remark\":{\"value\":\"欢迎再次购买！\",\"color\":\"#173177\"},\"keyword2\": {\"value\":\"39.8元\",\"color\":\"#173177\"},\"keyword3\":{\"value\":\"2014年9月22日\",\"color\":\"#173177\"}},\"touser\":\"o1S07wuDO9ivY_55p3OT4bEMNUL0\",\"template_id\":\"vte6h3EjUcir1uTdKgp8-WyjgxIzjyNGTPr3q4Akozk\",\"url\":\"\"}";
        String respMessage = httpRequest(url, "POST", jsonMenu);
        JSONObject jsonObject = JSONObject.fromObject(respMessage);
        System.out.println(jsonMenu);
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("发送模板消息失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
                System.out.println("发送模板消息失败");
            }
        }
        return result;
    }
}
