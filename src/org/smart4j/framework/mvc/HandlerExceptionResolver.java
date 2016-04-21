package org.smart4j.framework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
@ClassName: HandlerExceptionResolver
@Description: Handler 异常解析器
@author BEE 
@date 2016-4-21 上午10:08:52
 */
public interface HandlerExceptionResolver {

    /**
     * 解析 Handler 异常
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param e        异常
     */
    void resolveHandlerException(HttpServletRequest request, HttpServletResponse response, Exception e);
}
