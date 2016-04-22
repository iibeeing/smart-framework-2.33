package org.smart4j.framework.aop.proxy;

/**
@ClassName: Proxy
@Description: 代理接口
@author BEE 
@date 2016-4-22 下午4:16:39
 */
public interface Proxy {

    /**
     * 执行链式代理
     *
     * @param proxyChain 代理链
     * @return 目标方法返回值
     * @throws Throwable 异常
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
