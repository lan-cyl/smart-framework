package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作帮助类。不能动态修改类耶？要是经常用到，各个类型的类直接缓存起来咯
 *
 * Created by lan_cyl on 2016/11/2.
 */
public final class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classes.add(cls);
            }
        }
        return classes;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classes.add(cls);
            }
        }
        return classes;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.addAll(getServiceClassSet());
        classes.addAll(getControllerClassSet());
        return classes;
    }

    public static <T> Set<Class<T>> getClassSetByParent(Class<T> superClass) {
        Set<Class<T>> classes = new HashSet<Class<T>>();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classes.add((Class<T>) cls);
            }
        }
        return classes;
    }

    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classes.add(cls);
            }
        }
        return classes;
    }
}
