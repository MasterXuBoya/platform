package com.terabits.service;

import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.ClientInfoPO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
@Service
public interface ClientInfoService {
    public List<ClientInfoPO> selectClient(SelectDataBO selectDataBO);
}
