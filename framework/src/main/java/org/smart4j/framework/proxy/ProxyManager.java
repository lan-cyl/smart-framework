package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lan_cyl on 2016/11/4.
 */
public class ProxyManager {

    public static Object getProxy(final Class<?> targetClass, final List<Proxy> proxyChains) {

        return Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass, o, method, objects, methodProxy, proxyChains).doProxyChain();
            }
        });
    }
}
