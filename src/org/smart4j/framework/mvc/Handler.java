package org.smart4j.framework.mvc;

import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
@ClassName: Handler
@Description: 封装 Action 方法相关信息
@author BEE 
@date 2016-4-20 下午5:24:38
 */
public class Handler {

    private Class<?> actionClass;
    private Method actionMethod;
    private Matcher requestPathMatcher;

    public Handler(Class<?> actionClass, Method actionMethod) {
        this.actionClass = actionClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getActionClass() {
        return actionClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public Matcher getRequestPathMatcher() {
        return requestPathMatcher;
    }

    public void setRequestPathMatcher(Matcher requestPathMatcher) {
        this.requestPathMatcher = requestPathMatcher;
    }
}