package org.smart4j.framework.helper;

import org.apache.commons.collections.map.HashedMap;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.proxy.AspectProxy;
import org.smart4j.framework.proxy.Proxy;
import org.smart4j.framework.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lan_cyl on 2016/11/5.
 */
public class AopHelper {

    static {
        Map<Class<?>, List<Proxy>> targetClassToProxiesMap = getTargetClassToProxiesMap();
        for (Map.Entry<Class<?>, List<Proxy>> entry : targetClassToProxiesMap.entrySet()) {
            Class<?> targetClass = entry.getKey();
            List<Proxy> proxies = entry.getValue();
            BeanHelper.setBean(targetClass, ProxyManager.getProxy(targetClass, proxies));
        }
    }

    public static Map<Class<?>, List<Proxy>> getTargetClassToProxiesMap() {
        Map<Class<?>, List<Proxy>> targetClassToProxies = new HashedMap();// 类->代理链表
        Set<Class<AspectProxy>> proxySet = ClassHelper.getClassSetByParent(AspectProxy.class);
        for (Class<AspectProxy> proxyClass : proxySet) {
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);// 切面注解
                Class<? extends Annotation> annotation = aspect.value();// 目标注解
                Set<Class<?>> targetClassSet = ClassHelper.getClassSetByAnnotation(annotation);// 目标类集合
                addClassProxy(targetClassToProxies, targetClassSet, proxyClass);
            }
        }
        return targetClassToProxies;
    }

    private static void addClassProxy(Map<Class<?>, List<Proxy>> targetClassToProxies, Set<Class<?>> targetClassSet, Class<AspectProxy> proxyClass) {
        for (Class<?> targetClass : targetClassSet) {
            List<Proxy> proxies = targetClassToProxies.get(targetClass);
            if (proxies == null) {
                proxies = new ArrayList<>();
            }
            try {
                proxies.add(proxyClass.newInstance());
                targetClassToProxies.put(targetClass, proxies);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("instance proxy failure", e);
            }
        }
    }
}
