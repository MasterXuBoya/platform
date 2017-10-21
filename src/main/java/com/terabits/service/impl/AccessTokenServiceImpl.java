package com.terabits.service.impl;

import com.terabits.constant.ProjectGlobal;
import com.terabits.dao.AccessTokenDao;
import com.terabits.meta.bo.AccessTokenBO;
import com.terabits.meta.po.AccessTokenPO;
import com.terabits.service.AccessTokenService;
import com.terabits.utils.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    private AccessTokenDao accessTokenDao;
    public void insertToken(AccessTokenPO accessTokenPO){
        accessTokenDao.insertToken(accessTokenPO);
    }
    public AccessTokenPO getLatestToken(){
        AccessTokenPO accessTokenPO = accessTokenDao.selectLastToken();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = 0;
        try {
            Date begin =dfs.parse(accessTokenPO.getGmtCreate());
            Date end = new Date();
            between = (end.getTime() - begin.getTime())/1000;// 得到两者的秒数
            System.out.println(between);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if( between < 7000 ) {
            return accessTokenPO;
        }
        else {
            AccessTokenBO accessTokenBO = WeixinUtil.getAccessToken(ProjectGlobal.APP_ID, ProjectGlobal.APP_SECRET);
            AccessTokenPO accessTokenPO1 = new AccessTokenPO();
            accessTokenPO1.setAccessToken(accessTokenBO.getToken());
            insertToken(accessTokenPO1);
            return accessTokenPO1;
        }
    }


}
