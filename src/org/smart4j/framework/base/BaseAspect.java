package org.smart4j.framework.base;

import org.smart4j.framework.aop.proxy.Proxy;
import org.smart4j.framework.aop.proxy.ProxyChain;
import java.lang.reflect.Method;

public abstract class BaseAspect implements Proxy {
	public final Object doProxy(ProxyChain proxyChain) throws Exception {
		Object result = null;
		Class<?> cls = proxyChain.getTargetClass();
		Method method = proxyChain.getTargetMethod();
		Object[] params = proxyChain.getMethodParams();

		begin();
		try {
			if (intercept(cls, method, params)) {
				before(cls, method, params);
				try {
					result = proxyChain.doProxyChain();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				after(cls, method, params, result);
			} else {
				try {
					result = proxyChain.doProxyChain();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			error(cls, method, params, e);
			throw e;
		} finally {
			end();
		}

		return result;
	}

	public void begin() {
	}

	public boolean intercept(Class<?> cls, Method method, Object[] params)
			throws Exception {
		return true;
	}

	public void before(Class<?> cls, Method method, Object[] params)
			throws Exception {
	}

	public void after(Class<?> cls, Method method, Object[] params,
			Object result) throws Exception {
	}

	public void error(Class<?> cls, Method method, Object[] params, Exception e) {
	}

	public void end() {
	}
}
