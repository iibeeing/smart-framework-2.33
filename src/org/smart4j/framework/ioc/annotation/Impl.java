package org.smart4j.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
@ClassName: Impl
@Description: 指定接口的实现类，建议给一个某个接口实现类该注解，(最好)一定要有，且只能一个
@author BEE 
@date 2016-4-22 下午4:00:42
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Impl {

    Class<?> value();
}
