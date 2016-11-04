package org.smart4j.framework.bean;

import org.smart4j.framework.util.JsonUtil;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public class Data {
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }

    public String toJson() {
        return JsonUtil.toJson(model);
    }
}
