package org.smart4j.framework.mvc;

/**
@ClassName: Requester
@Description: 封装 Request 对象相关信息
@author BEE 
@date 2016-4-21 上午11:32:32
 */
public class Requester {

    private String requestMethod;
    private String requestPath;

    public Requester(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }
}