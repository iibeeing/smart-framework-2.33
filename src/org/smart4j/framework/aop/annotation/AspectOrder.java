package org.smart4j.framework.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
@ClassName: AspectOrder
@Description: 定义切面顺序
@author BEE 
@date 2016-4-22 下午4:15:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectOrder {

    int value();
}
