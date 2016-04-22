package org.smart4j.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
@ClassName: Bean
@Description: 定义需要 IOC 容器管理的 Bean 类
@author BEE 
@date 2016-4-22 下午3:33:48
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
}
