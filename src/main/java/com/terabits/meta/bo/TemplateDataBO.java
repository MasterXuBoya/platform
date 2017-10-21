package com.terabits.meta.bo;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/15.
 */
public class TemplateDataBO extends HashMap<String, ItemBO> {
    private static final long serialVersionUID = -3728490424738325020L;

    public TemplateDataBO() {}

    public TemplateDataBO(String key, ItemBO item) {
        this.put(key, item);
    }

}
