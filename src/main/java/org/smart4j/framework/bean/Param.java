package org.smart4j.framework.bean;

import org.apache.commons.collections.map.HashedMap;
import org.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, String[]> paramMap) {
        this.paramMap = new HashedMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (value == null)
                this.paramMap.put(key, null);
            else if (value.length == 1)
                this.paramMap.put(key, value[0]);
            else
                this.paramMap.put(key, value);
        }
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public String getString(String name) {
        return CastUtil.castString(paramMap.get(name));
    }
}
