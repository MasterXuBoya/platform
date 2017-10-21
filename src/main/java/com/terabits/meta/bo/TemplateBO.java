package com.terabits.meta.bo;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/15.
 */
public class TemplateBO {
    private String template_id;//模板ID
    private String touser;//目标客户
    private String url;//用户点击模板信息的跳转页面
    private String topcolor;//字体颜色
    private TemplateDataBO data;//模板里的数据

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public TemplateDataBO getData() {
        return data;
    }

    public void setData(TemplateDataBO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TemplateBO{" +
                "template_id='" + template_id + '\'' +
                ", touser='" + touser + '\'' +
                ", url='" + url + '\'' +
                ", topcolor='" + topcolor + '\'' +
                ", data=" + data +
                '}';
    }
}
