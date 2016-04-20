package org.smart4j.framework.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
@ClassName: Request
@Description: 定义请求
@author BEE 
@date 2016-4-20 上午10:03:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
	
	/**
	@ClassName: Get
	@Description: 定义 GET 请求
	@author BEE 
	@date 2016-4-20 上午10:03:52
	 */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Get {

        String value();
    }

    /**
    @ClassName: Post
    @Description: 定义 POST 请求
    @author BEE 
    @date 2016-4-20 上午10:04:02
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Post {

        String value();
    }

    /**
    @ClassName: Put
    @Description: 定义 PUT 请求
    @author BEE 
    @date 2016-4-20 上午10:04:12
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Put {

        String value();
    }

    /**
    @ClassName: Delete
    @Description: 定义 DELETE 请求
    @author BEE 
    @date 2016-4-20 上午10:04:22
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Delete {

        String value();
    }
}
