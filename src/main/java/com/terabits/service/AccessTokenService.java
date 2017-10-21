package com.terabits.service;

import com.terabits.meta.po.AccessTokenPO;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface AccessTokenService {
    public void insertToken(AccessTokenPO accessTokenPO);
    public AccessTokenPO getLatestToken();
}
