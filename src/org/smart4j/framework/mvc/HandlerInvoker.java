package org.smart4j.framework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
@ClassName: HandlerInvoker
@Description: Handler 调用器，就是调用handle中封装的方法，就是运行Action中所请求映射的函数
@author BEE 
@date 2016-4-21 上午10:09:04
 */
public interface HandlerInvoker {

    /**
     * 调用 Handler
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  Handler
     * @throws Exception 异常
     */
    void invokeHandler(HttpServletRequest request, HttpServletResponse response, Handler handler) throws Exception;
}
