package com.terabits.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.terabits.dao.DataDao;
import com.terabits.dao.LogDao;
import com.terabits.dao.MeterDao;
import com.terabits.dao.TerminalDao;
import com.terabits.iotconnetion.PlatformGlobal;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.meta.vo.MeterStatusVO;
import com.terabits.service.MeterService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service("meterService")
public class MeterServiceImpl implements MeterService {
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private LogDao logDao;
    @Autowired
    private DataDao buildingDao;

    public void add(List<MeterPO> meterPOS, List<LogPO> logPOS) throws Exception {
    	
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        if (adminUserPO == null) {
        	throw new Exception("请重新登录。");
        }
        String community = adminUserPO.getCommunity();
        
        //查看并分配相对位置
        List<Integer> relativeLocationS = meterDao.selectAllRelctiveLocationByImei(meterPOS.get(0).getTerminalImei());
        if (relativeLocationS.size() + meterPOS.size() > PlatformGlobal.limitDevicesByOneTerminal) {
            throw new Exception("终端电表数已达到最大");
        }
        int[] array = new int[PlatformGlobal.limitDevicesByOneTerminal];
        for (int i = 0; i < PlatformGlobal.limitDevicesByOneTerminal; i++) array[i] = 0;
        for (Integer relativeLocation : relativeLocationS) {
            array[relativeLocation - 1] = 1;
        }
        int index = 0;
        for (int i = 0; i < PlatformGlobal.limitDevicesByOneTerminal; i++) {
            if (array[i] == 0) {
                meterPOS.get(index).setRelativeLocation(i + 1);
                meterPOS.get(index).setCommunity(community);
                index++;
            }
            if (index == meterPOS.size()) {
            	break;
            }
        }
        
        //数据库添加电表
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("meterPOS", meterPOS);
        int result = meterDao.insertMeter(params);
        if (result == 400) {
            throw new Exception("电表添加失败。");
        }
        
        //创建对应的数据表
        for (MeterPO meterPO : meterPOS) {
    		buildingDao.createNewTable(community, "data_" + community + "_" + meterPO.getBuilding());
        }
        
        //向终端发送添加电表命令
        try {
        	setMeterAddress(meterPOS);
        } catch (Exception e) {
        	//下发地址失败，删除数据库添加信息
        	for (MeterPO meterPO : meterPOS) {
        		meterDao.deleteMeter(community, meterPO.getBuilding(), meterPO.getRoom());
        	}
        	throw new Exception("电表添加失败，请输入正确的电表地址。");
        }
        
        boolean succ = true;
        //重传命令
        for (int i = 0; i < 3; i++) {
	        Thread.sleep(3000);
	        succ = true;
	        for (MeterPO meterPO : meterPOS) {
	        	int meterState = meterDao.selectOneMeter(community, meterPO.getBuilding(), meterPO.getRoom()).getMeterState();
	        	if (meterState == 0) {
	        		succ = false;
	        	}
	        }
	        if (succ || i == 2)
	        	break;
	        else setMeterAddress(meterPOS);
        }
        if (!succ) {
        	//下发地址失败，删除数据库添加信息
        	for (MeterPO meterPO : meterPOS) {
        		meterDao.deleteMeter(community, meterPO.getBuilding(), meterPO.getRoom());
        	}
        	throw new Exception("电表添加失败，请2分钟后再添加电表。");
        }
        
        //添加日志
        for (int i = 0; i < logPOS.size(); i++) {
        	logDao.insertLog(logPOS.get(i));
        }
        
        
    }

    public void remove(List<MeterPO> meterPOS, List<LogPO> logPOS) throws Exception {
    	
    	Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        AdminUserPO adminUserPO = (AdminUserPO) session.getAttribute("currentUser");
        if (adminUserPO == null) {
        	throw new Exception("请重新登录。");
        }
        String community = adminUserPO.getCommunity();
        
    	//选择删除电表
    	List<MeterPO> newMeterPOS = new ArrayList<MeterPO>();
    	for (MeterPO meterPO : meterPOS) {
    		meterPO = meterDao.selectOneMeter(community, meterPO.getBuilding(), meterPO.getRoom());
    		newMeterPOS.add(meterPO);
    	}    	
    	
    	//向终端发送删除电表命令
    	removeMeterAddress(newMeterPOS);
    	
        //数据库删除电表
        String meterLocation = "";
        for (MeterPO meterPO : meterPOS) {
        	int result = meterDao.deleteMeter(community, meterPO.getBuilding(), meterPO.getRoom());
            if (result == 400) {
            	if (meterLocation.equals(""))
            		meterLocation += meterPO.getBuilding() + "-" + meterPO.getRoom();
            	else meterLocation += "; " + meterPO.getBuilding() + "-" + meterPO.getRoom();
            }
        }
        if (!meterLocation.equals("")) {
        	throw new Exception("电表" + meterLocation + "删除失败。");
        }
        
        //添加日志
        for (int i = 0; i < logPOS.size(); i++) {
        	logDao.insertLog(logPOS.get(i));
        }

    }

    public List<String> queryBuilding(String community) {
        return meterDao.selectAllBuilding(community);
    }

    public List<String> queryRoom(String community, String building) {
        return meterDao.selectAllRoomByBuilding(community, building);
    }

    public void setMeterAddress(List<MeterPO> meterPOS) throws Exception {
        int meterNumber = meterPOS.size() / 10 * 16 + meterPOS.size() % 10;
        String meterAddress = "";
        String meterRelativeLocation = "";
        for (MeterPO meterPO : meterPOS) {
            String meterSingleAddress = meterPO.getMeterId();
            for (int i = 0; i < meterSingleAddress.length(); i = i + 2) {
                char temp = (char)((meterSingleAddress.charAt(i) - '0') * 16 + meterSingleAddress.charAt(i + 1) - '0');
                meterAddress += temp;
            }
            int relativeLocation = meterPO.getRelativeLocation();
            relativeLocation = (relativeLocation / 10) * 16 + (relativeLocation % 10);
            meterRelativeLocation += (char) relativeLocation;
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("meterNumber", meterNumber);
        node.put("meterAddress", meterAddress);
        node.put("meterId", meterRelativeLocation);
        TerminalPO terminalPO = terminalDao.selectOneTerminal(meterPOS.get(0).getTerminalImei());
        PlatformGlobal.command(terminalPO.getTerminalId(), "METER_ID", node);
    }
    
    public void removeMeterAddress(List<MeterPO> meterPOS) throws Exception {
        int meterNumber = meterPOS.size();
        String meterAddress = "";
        String meterRelativeLocation = "";
        for (MeterPO meterPO : meterPOS) {
            String meterSingleAddress = meterPO.getMeterId();
            for (int i = 0; i < meterSingleAddress.length(); i = i + 2) {
                char temp = (char)((meterSingleAddress.charAt(i) - '0') * 16 + meterSingleAddress.charAt(i + 1) - '0');
                meterAddress += temp;
            }
            int relativeLocation = meterPO.getRelativeLocation();
            relativeLocation = (relativeLocation / 10) * 16 + (relativeLocation % 10);
            char temp = (char) (0x32 + (char) relativeLocation);
            meterRelativeLocation += temp;
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("meterNumber", meterNumber);
        node.put("meterAddress", meterAddress);
        node.put("meterId", meterRelativeLocation);
        TerminalPO terminalPO = terminalDao.selectOneTerminal(meterPOS.get(0).getTerminalImei());
        PlatformGlobal.command(terminalPO.getTerminalId(), "METER_ID", node);
    }

    public void setMeterState(String terminalId, int relativeLocation, int state) {
        TerminalPO terminalPO = terminalDao.selectOneTerminalById(terminalId);
        MeterPO meterPO = meterDao.selectMeterByRelativeLocation(terminalPO.getTerminalImei(), relativeLocation);
        if (state == 3) {
        	meterDao.deleteMeter(terminalPO.getCommunity(), meterPO.getBuilding(), meterPO.getRoom());
        } else {
        	meterDao.updateMeterState(terminalPO.getCommunity(), state, meterPO.getBuilding(), meterPO.getRoom());
        }
    }

    public void sendStartOrStopCommand(List<MeterPO> meterPOS, int command, List<LogPO> logPOS) throws Exception {
    	//meter按终端分类
    	Map<String, List<MeterPO>> map = new HashMap<String, List<MeterPO>>();
    	List<String> terminalIdS = new ArrayList<String>();
    	for (MeterPO meterPO : meterPOS) {
    		meterPO = meterDao.selectOneMeter(meterPO.getCommunity(), meterPO.getBuilding(), meterPO.getRoom());
    		String terminalId = terminalDao.selectOneTerminal(meterPO.getTerminalImei()).getTerminalId();
    		if (map.containsKey(terminalId)) {
    			map.get(terminalId).add(meterPO);
    		} else {
    			List<MeterPO> meter = new ArrayList<MeterPO>();
    			meter.add(meterPO);
    			map.put(terminalId, meter);
    			terminalIdS.add(terminalId);
    		}
    	}
    	
    	//生产透传命令，详见终端数据格式
    	byte left = 0, right = 0;
    	if (command == 0) {
    		left = 0x20;
    		right = 0x02;
    	} else {
    		left = 0x10;
    		right = 0x01;
    	}
    	Map<String, byte[]> commandMap = new HashMap<String, byte[]>();
    	for (Map.Entry<String, List<MeterPO>> entry : map.entrySet()) {
    		byte[] commandBytes = new byte[18];
    		commandBytes[0] = (byte) 0xAF;
    		for (int i = 1; i < 17; i++) {
    			commandBytes[i] = (byte) 0x33;
    		}
    		for (MeterPO meterPO : entry.getValue()) {
    			int relativeLocation = meterPO.getRelativeLocation();
    			int index = (relativeLocation + 1) / 2;
    			if (relativeLocation % 2 == 1) {
    				commandBytes[index] = (byte) (commandBytes[index] - 0x30 + left);
    			} else {
    				commandBytes[index] = (byte) (commandBytes[index] - 0x03 + right);
    			}
    		}
    		commandBytes[17] = (byte) 0xEF;
    		commandMap.put(entry.getKey(), commandBytes);
    	}
    	
    	//下发命令
    	for (Map.Entry<String, List<MeterPO>> entry : map.entrySet()) {
    		PlatformGlobal.command(commandMap.get(entry.getKey()), entry.getKey());
    	}
    	
    	//重传机制
    	command = 2 - command;  //1表示开启，2表示关闭
    	for (int i = 0; i < 3; i++) {
    		Thread.sleep(3000);
    		for (String terminalId : terminalIdS) {
    			boolean succ = true;
        		for(MeterPO meterPO : map.get(terminalId)) {
        			if (meterDao.selectOneMeter(meterPO.getCommunity(), meterPO.getBuilding(), meterPO.getRoom()).getMeterState() != command) {
        				succ = false;
        				break;
        			}
        		}
        		if (succ) {
        			map.remove(terminalId);
        		}
        	}
    		if (map.isEmpty() || i == 2) {
    			break;
    		} else {
    			for (Map.Entry<String, List<MeterPO>> entry : map.entrySet()) {
    	    		PlatformGlobal.command(commandMap.get(entry.getKey()), entry.getKey());
    	    	}
    		}
    	}
    	
    	//判断命令下发是否成功
    	if (!map.isEmpty()) {
    		StringBuilder meter = new StringBuilder("");
    		for (Map.Entry<String, List<MeterPO>> entry : map.entrySet()) {
    			for(MeterPO meterPO : entry.getValue()) {
    				meter.append(meterPO.getBuilding() + "-" + meterPO.getRoom() + ";");
        		}
	    	}
    		meter.deleteCharAt(meter.length() - 1);
    		throw new Exception("电表：" + meter + " 操作失败。请2分钟后再进行操作。");
    	}
    	
    	//添加日志
        for (int i = 0; i < logPOS.size(); i++) {
        	logDao.insertLog(logPOS.get(i));
        }
    }

    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO) {
        return meterDao.selectMeterInfo(selectDataBO);
    }

    public List<MeterClientPO> queryMeterClient(LocationBO locationBO) {
        return meterDao.queryMeterClient(locationBO);
    }

    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS) {
        return meterDao.selectListMeter(locationBOS);
    }

    public List<LocationBO> getAllMeter(String community) {
        return meterDao.getAllMeter(community);
    }

    public List<MeterClientPO> queryForArrearage(String community) {
        return meterDao.queryForArrearage(community);
    }
    //在每次充值后更新电表余额
    public int updateMeterRemain(String community, double remain, String building, String room){
        return meterDao.updateMeterRemain(community, remain, building, room);
    }
}
