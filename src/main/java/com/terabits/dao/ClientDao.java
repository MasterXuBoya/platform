package com.terabits.dao;

import com.terabits.dao.mapper.ClientInfoMapper;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Repository("clientDao")
public class ClientDao {
  /*  public static void main(String[] args){
       *//* ClientInfoPO clientInfoPO = new ClientInfoPO();
        clientInfoPO.setbuilding("01");
        clientInfoPO.setRoom("102");
        clientInfoPO.setName("秀兰杨");
        clientInfoPO.setPhone("13312343467");
        clientInfoPO.setOpenId("543214344ULL42434354");*//*
        //insertClientInfo(clientInfoPO);
       *//* SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBuilding("01");
        selectDataBO.setRoom("102");*//*
        System.out.println(selectClientByOpenId("543214344ULL42434354"));
    }*/

    //新增用户数据
    public int insertClientInfo(ClientInfoPO clientInfoPO) {
        SqlSession session = DBTools.getSession();
        ClientInfoMapper mapper = session.getMapper(ClientInfoMapper.class);
        try {
            mapper.insertClientInfo(clientInfoPO);
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


    //根据楼号和室号删除用户数据
    public int deleteClientInfo(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        ClientInfoMapper mapper = session.getMapper(ClientInfoMapper.class);
        try {
            mapper.deleteClientInfo(selectDataBO);
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

    //根据楼号和室号查询用户数据
    public List<ClientInfoPO> selectClientInfo(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        ClientInfoMapper mapper = session.getMapper(ClientInfoMapper.class);
        List<ClientInfoPO> clientInfoPOS = new ArrayList<ClientInfoPO>();
        try {
            clientInfoPOS = mapper.selectClientInfo(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return clientInfoPOS;
    }

    //根据openid查询用户的楼号和室号
    public ClientInfoPO selectClientByOpenId(String openId){
        SqlSession session = DBTools.getSession();
        ClientInfoMapper mapper = session.getMapper(ClientInfoMapper.class);
        ClientInfoPO clientInfoPO = new ClientInfoPO();
        try {
            clientInfoPO = mapper.selectClientByOpenId(openId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return clientInfoPO;
    }

    //查询全部用户数据
    public List<ClientInfoPO> selectAllClient(String community) {
        SqlSession session = DBTools.getSession();
        ClientInfoMapper mapper = session.getMapper(ClientInfoMapper.class);
        List<ClientInfoPO> clientInfoPOS = new ArrayList<ClientInfoPO>();
        try {
            clientInfoPOS = mapper.selectAllClient(community);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
        	session.close();
        }
        return clientInfoPOS;
    }
}
