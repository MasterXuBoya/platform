package com.terabits.dao;

import com.terabits.dao.mapper.AccessTokenMapper;
import com.terabits.meta.po.AccessTokenPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
@Repository("accessTokenDao")
public class AccessTokenDao {
    //新增token
    public int insertToken(AccessTokenPO accessTokenPO){
        SqlSession session = DBTools.getSession();
        AccessTokenMapper mapper = session.getMapper(AccessTokenMapper.class);
        try {
            mapper.insertToken(accessTokenPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        } finally {
        	session.close();
        }
        return 200;
    }

    //取回最新的token
    public AccessTokenPO selectLastToken(){
        SqlSession session = DBTools.getSession();
        AccessTokenMapper mapper = session.getMapper(AccessTokenMapper.class);
        AccessTokenPO accessTokenPO = new AccessTokenPO();
        try {
            accessTokenPO = mapper.selectLastToken();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        	session.close();
        }
        return accessTokenPO;
    }

    //取回全部的token
    public List<AccessTokenPO> selectAllToken(){
        SqlSession session = DBTools.getSession();
        AccessTokenMapper mapper = session.getMapper(AccessTokenMapper.class);
        List<AccessTokenPO> accessTokenPOS = new ArrayList<AccessTokenPO>();
        try {
            accessTokenPOS = mapper.selectAllToken();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        	session.close();
        }
        return accessTokenPOS;
    }
}
