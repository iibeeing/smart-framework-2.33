package org.smart4j.framework.mvc;

/**
@ClassName: HandlerMapping
@Description: 处理器映射，就是根据请求类型和请求路径，在代码中找到对应的方法，这里把方法封装到了Handler中
@author BEE 
@date 2016-4-20 下午5:29:37
 */
public interface HandlerMapping {

    /**
     * 获取 Handler
     *
     * @param currentRequestMethod 当前请求方法
     * @param currentRequestPath   当前请求路径
     * @return Handler
     */
    Handler getHandler(String currentRequestMethod, String currentRequestPath);
}
