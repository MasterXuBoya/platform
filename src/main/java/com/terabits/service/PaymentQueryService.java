package com.terabits.service;

import com.terabits.meta.vo.ClientInfoVO;
import com.terabits.meta.vo.PaymentVO;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
public interface PaymentQueryService {
    public JSONArray queryRemain(String community, String building, String room);
    public List<PaymentVO> queryPayment(String community, String building, String room, String begin, String end);
    public int munualDeposit(String community, String building, String room, String money);
    public void feeReminder(String building, String room);
    public JSONArray arrearage(String community);
}
