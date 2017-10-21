package com.terabits.utils;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
public class GenerateOrderId {
    public static String generateOrderId(int k){
        Date date = new Date();
        String orderId = String.format("%tY%<tm%<td%06d", date, k);
        return orderId;
    }
}
