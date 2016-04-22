package org.smart4j.framework.aop.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.sf.cglib.proxy.MethodProxy;

/**
@ClassName: ProxyChain
@Description: 代理链
@author BEE 
@date 2016-4-22 下午4:16:53
 */
public class ProxyChain {

	//目标类
    private final Class<?> targetClass;
    //目标对象
    private final Object targetObject;
    //目标方法
    private final Method targetMethod;
    //代理方法
    private final MethodProxy methodProxy;
    //代理方法参数
    private final Object[] methodParams;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxyIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object doProxyChain() throws Throwable {
        Object methodResult;
        if (proxyIndex < proxyList.size()) {
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetObject, methodParams);
        }
        return methodResult;
    }
}
