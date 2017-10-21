package com.terabits.service.impl;

import com.terabits.dao.ClientDao;
import com.terabits.dao.MeterDao;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.ClientInfoVO;
import com.terabits.service.ClientBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service("clientBalanceService")
public class ClientBalanceServiceImpl implements ClientBalanceService {
    @Autowired
    private MeterDao meterDao;
    public void queryClientBalance(){
        ClientDao clientDao = new ClientDao();
        ClientInfoPO clientInfoPO = clientDao.selectClientByOpenId("543214344ULL42434354");
        MeterPO meterPO = meterDao.selectOneMeter(clientInfoPO.getCommunity(), clientInfoPO.getBuilding(),clientInfoPO.getRoom());
        ClientInfoVO clientInfoVO = new ClientInfoVO();
        clientInfoVO.setBuilding(clientInfoPO.getBuilding());
        clientInfoVO.setRoom(clientInfoPO.getRoom());
        clientInfoVO.setName(clientInfoPO.getName());
        clientInfoVO.setPhone(clientInfoPO.getPhone());
        clientInfoVO.setRemain(meterPO.getMeterRemain());
        System.out.println(clientInfoVO);
    }
}
