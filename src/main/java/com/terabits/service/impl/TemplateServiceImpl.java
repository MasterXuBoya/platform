package com.terabits.service.impl;

import com.terabits.dao.AccessTokenDao;
import com.terabits.meta.bo.ItemBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.bo.TemplateBO;
import com.terabits.meta.bo.TemplateDataBO;
import com.terabits.service.AccessTokenService;
import com.terabits.service.TemplateService;
import com.terabits.utils.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private AccessTokenService accessTokenService;

    public void feeReminder(String openId, String name, String balance) {

        TemplateBO template = new TemplateBO();
        template.setUrl("");
        template.setTouser(openId);
        template.setTopcolor("#ff0000");
        template.setTemplate_id("vte6h3EjUcir1uTdKgp8-WyjgxIzjyNGTPr3q4Akozk");
        TemplateDataBO templateData = new TemplateDataBO();
        ItemBO first = new ItemBO();
        first.setColor("#000000");
        first.setValue("亲爱的户主，您2017年5月的电费单还未支付。");
        templateData.put("fisrt", first);
        ItemBO keyword1 = new ItemBO();
        keyword1.setColor("#328392");
        keyword1.setValue("01102");
        templateData.put("keyword1", keyword1);
        ItemBO keyword2 = new ItemBO();
        keyword2.setColor("#328392");
        keyword2.setValue(name);
        templateData.put("keyword2", keyword2);
        ItemBO keyword3 = new ItemBO();
        keyword3.setColor("#328392");
        keyword3.setValue(balance);
        templateData.put("keyword3", keyword3);
        ItemBO remark = new ItemBO();
        remark.setColor("#328392");
        remark.setValue("为了保障您正常用电，请在停电日期2017-06-28前完成电费支付");
        templateData.put("remark", remark);
        /*Map<String, TemplateDataBO> tempMap = new HashMap<String, TemplateDataBO>();
        tempMap.put("data", templateData);*/
        template.setData(templateData);
        System.out.println("template:"+template);
        WeixinUtil.sendMessage(template, accessTokenService.getLatestToken().getAccessToken());
    }
}
