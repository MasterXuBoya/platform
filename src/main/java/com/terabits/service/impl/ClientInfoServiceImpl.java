package com.terabits.service.impl;

import com.terabits.dao.ClientDao;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import com.terabits.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
@Service("clientInfoService")
public class ClientInfoServiceImpl implements ClientInfoService {
    @Autowired
    private ClientDao clientDao;
    public List<ClientInfoPO> selectClient(SelectDataBO selectDataBO){
        return clientDao.selectClientInfo(selectDataBO);
    }

}
