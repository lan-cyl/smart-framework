package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面抽象类，提供一系列钩子方法：
 * begin\intercept\before\after\error\end，根据需要重写对应方法
 * <p>
 * Created by lan_cyl on 2016/11/4.
 */
public abstract class AspectProxy implements Proxy {
    private final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) {
        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getParams();

        Object result = null;

        begin();
        try {
            if (intercept(targetClass, targetMethod, params)) {
                before(targetClass, targetMethod, params);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, params);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Throwable e) {
            LOGGER.error("do proxy failure", e);
            error(targetClass, targetMethod, params, e);
            try {
                throw e;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } finally {
            end();
        }
        return result;
    }

    public void begin() {
    }

    public boolean intercept(Class<?> targetClass, Method targetMethod, Object[] params) {
        return true;
    }

    public void before(Class<?> targetClass, Method targetMethod, Object[] params) {
    }

    public void after(Class<?> targetClass, Method targetMethod, Object[] params) {
    }

    public void error(Class<?> targetClass, Method targetMethod, Object[] params, Throwable e) {
    }

    public void end() {
    }
}
