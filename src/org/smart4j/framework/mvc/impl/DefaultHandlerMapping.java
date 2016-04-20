package org.smart4j.framework.mvc.impl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.smart4j.framework.mvc.ActionHelper;
import org.smart4j.framework.mvc.Handler;
import org.smart4j.framework.mvc.HandlerMapping;
import org.smart4j.framework.mvc.Requester;

/**
@ClassName: DefaultHandlerMapping
@Description: 默认处理器映射
@author BEE 
@date 2016-4-20 下午5:25:30
 */
public class DefaultHandlerMapping implements HandlerMapping {

    @Override
    public Handler getHandler(String currentRequestMethod, String currentRequestPath) {
        // 定义一个 Handler
        Handler handler = null;
        // 获取并遍历 Action 映射，比如这里Action是UserAction，actionMap就是UserAction中所有的方法
        //然后遍历这些方法，找到跟currentRequestMethod（POST） currentRequestPath方法名，可以匹配的
        //Handler，这些Handler是已经实例化过的，可以直接用
        Map<Requester, Handler> actionMap = ActionHelper.getActionMap();
        //遍历方法
        for (Map.Entry<Requester, Handler> actionEntry : actionMap.entrySet()) {
            // 从 Requester 中获取 Request 相关属性
            Requester requester = actionEntry.getKey();
            //比如 POST
            String requestMethod = requester.getRequestMethod();
            //比如user/1
            String requestPath = requester.getRequestPath(); // 正则表达式
            // 获取请求路径匹配器（使用正则表达式匹配请求路径并从中获取相应的请求参数）
            Matcher requestPathMatcher = Pattern.compile(requestPath).matcher(currentRequestPath);
            // 判断请求方法与请求路径是否同时匹配
            if (requestMethod.equalsIgnoreCase(currentRequestMethod) && requestPathMatcher.matches()) {
                // 获取 Handler 及其相关属性，就是handle的实例
                handler = actionEntry.getValue();
                // 设置请求路径匹配器
                if (handler != null) {
                    handler.setRequestPathMatcher(requestPathMatcher);
                }
                // 若成功匹配，则终止循环
                break;
            }
        }
        // 返回该 Handler
        return handler;
    }
}
