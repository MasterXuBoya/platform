package com.terabits.dao;

import com.terabits.dao.mapper.MeterMapper;
import com.terabits.dao.mapper.TerminalMapper;
import com.terabits.meta.bo.FrequencyBO;
import com.terabits.meta.bo.TerminalBO;
import com.terabits.meta.bo.TerminalGroupBO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
@Repository("terminalDao")
public class TerminalDao {
   /* public static void main(String args[]){

        List<TerminalGroupBO> terminalGroupBOS = new ArrayList<TerminalGroupBO>();
        TerminalGroupBO terminalGroupBO1 = new TerminalGroupBO();
        terminalGroupBO1.setState(0);
        terminalGroupBO1.setImei("863703030057025");
        TerminalGroupBO terminalGroupBO2 = new TerminalGroupBO();
        terminalGroupBO2.setState(0);
        terminalGroupBO2.setImei("863703030057140");
        terminalGroupBOS.add(terminalGroupBO1);
        terminalGroupBOS.add(terminalGroupBO2);
        //updateGroupState(terminalGroupBOS);

    }*/
   //新增终端数据
    public int insertTerminal(TerminalPO terminalPO) {
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.insertTerminal(terminalPO);
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
    //更新终端sim卡卡号，余额及状态
    public int updateTerminal(TerminalBO terminalBO){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminal(terminalBO);
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
    //更新终端sim卡卡号，余额及状态
    public int updateTerminalImei(String newImei, String oldImei){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminalImei(newImei, oldImei);
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
    //更新频率
    public int updateFrequency(FrequencyBO frequencyBO){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateFrequency(frequencyBO);
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
    //更新终端sim卡号
    public int updateTerminalSimId(String simId, String imei){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminalSimId(simId, imei);
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
    //更新终端sim卡余额
    public int updateTerminalSimRemain(double simRemain, String imei){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminalSimRemain(simRemain, imei);
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
    //更新终端状态
    public int updateTerminalState(int terminalState, String imei){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminalState(terminalState, imei);
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
    //批量更新终端状态
    public int updateGroupState(List<TerminalGroupBO> terminalGroupBOList) {
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateGroupState(terminalGroupBOList);
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

    //更新终端创建时间
    public int updateTerminalCreateTime(String createTime, String imei) throws Exception {
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        try {
            mapper.updateTerminalCreateTime(createTime, imei);
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

    //删除终端
    public int deleteTerminal(String terminalImei){
        SqlSession session = DBTools.getSession();
        TerminalMapper terminalMapper = session.getMapper(TerminalMapper.class);
        MeterMapper meterMapper = session.getMapper(MeterMapper.class);
        try {
            terminalMapper.deleteTerminal(terminalImei);
            meterMapper.deleteGroupMeter(terminalImei);
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
    //查询一个终端数据
    public TerminalPO selectOneTerminal(String terminalImei){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        TerminalPO terminalPO = null;
        try {
            terminalPO = mapper.selectOneTerminal(terminalImei);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();

        } finally {
        	session.close();
        }
        return terminalPO;
    }
    //查询一个终端数据
    public TerminalPO selectOneTerminalById(String terminalId){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        TerminalPO terminalPO = new TerminalPO();
        try {
            terminalPO = mapper.selectOneTerminalById(terminalId);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();

        } finally {
        	session.close();
        }
        return terminalPO;
    }
    //查询全部终端数据
    public List<TerminalPO> selectAllTerminal(){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        List<TerminalPO> terminalPO = new ArrayList<TerminalPO>();
        try {
            terminalPO = mapper.selectAllTerminal();
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();

        } finally {
        	session.close();
        }
        return terminalPO;
    }
    
    //查询某社区全部终端数据
    public List<TerminalPO> selectAllTerminalByCommunity(String community){
        SqlSession session = DBTools.getSession();
        TerminalMapper mapper = session.getMapper(TerminalMapper.class);
        List<TerminalPO> terminalPO = new ArrayList<TerminalPO>();
        try {
            terminalPO = mapper.selectAllTerminalByCommunity(community);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();

        } finally {
        	session.close();
        }
        return terminalPO;
    }
}
