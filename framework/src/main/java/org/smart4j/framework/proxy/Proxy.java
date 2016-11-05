package org.smart4j.framework.proxy;

/**
 * Created by lan_cyl on 2016/11/4.
 */
public interface Proxy {
    /**
     * 执行链式代理
     *
     * @param proxyChain 代理链
     * @return
     */
    Object doProxy(ProxyChain proxyChain);
}
