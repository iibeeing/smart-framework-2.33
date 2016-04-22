package org.smart4j.framework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
@ClassName: ViewResolver
@Description: 视图解析器
@author BEE 
@date 2016-4-21 下午2:32:12
 */
public interface ViewResolver {

    /**
     * 解析视图
     *
     * @param request            请求对象
     * @param response           响应对象
     * @param actionMethodResult Action 方法返回值
     */
    void resolveView(HttpServletRequest request, HttpServletResponse response, Object actionMethodResult);
}
