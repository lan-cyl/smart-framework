package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ClassUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 完成依赖注入功能
 *
 * Created by lan_cyl on 2016/11/2.
 */
public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
            Class<?> aClass = entry.getKey();
            Object instance = entry.getValue();
            for (Field field : aClass.getDeclaredFields())
                if (field.isAnnotationPresent(Inject.class)) {
                    ReflectionUtil.setField(instance, field, beanMap.get(field.getType()));
                }
        }
    }
}
