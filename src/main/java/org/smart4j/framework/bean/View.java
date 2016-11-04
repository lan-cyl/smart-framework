package org.smart4j.framework.bean;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public class View {
    private String path;
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        this.model = new HashedMap();
    }

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
