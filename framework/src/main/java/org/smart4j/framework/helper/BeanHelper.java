package org.smart4j.framework.helper;

import org.apache.commons.collections.map.HashedMap;
import org.smart4j.framework.util.ReflectionUtil;

import java.util.Map;

/**
 * Created by lan_cyl on 2016/11/2.
 */
public final class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashedMap();

    static {
        for (Class<?> cls : ClassHelper.getBeanClassSet()) {
            BEAN_MAP.put(cls, ReflectionUtil.newInstance(cls));
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        try {
            return (T) BEAN_MAP.get(cls);
        } catch (Exception e) {
            throw new RuntimeException("can not get bean by class: " + cls, e);
        }
    }
    public static void setBean(Class<?> cls, Object instance) {
        BEAN_MAP.put(cls, instance);
    }
}
