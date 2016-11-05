package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lan_cyl on 2016/11/4.
 */
public class ProxyChain {
    private Class<?> targetClass;
    private Object targetObject;
    private Method targetMethod;
    private Object[] params;
    private MethodProxy methodProxy;

    private List<Proxy> proxyChains;
    private int index = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, Object[] params, MethodProxy methodProxy, List<Proxy> proxyChains) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.params = params;
        this.methodProxy = methodProxy;
        this.proxyChains = proxyChains;
    }

    public Object doProxyChain() throws Throwable {
        if (index < this.proxyChains.size()) {
            return this.proxyChains.get(index++).doProxy(this);// 执行代理链中的当前代理，当前代理内又会调用this.doProxyChain()，即继续调用代理链中的代理
        } else {
            return methodProxy.invokeSuper(targetObject, params);// 直到代理链中的代理执行完了
        }
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getParams() {
        return params;
    }
}
