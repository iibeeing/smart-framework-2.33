package org.smart4j.framework.core.impl.support;

import java.lang.annotation.Annotation;

/**
@ClassName: AnnotationClassTemplate
@Description: 用于获取注解类的模板类
@author BEE 
@date 2016-4-21 上午10:27:17
 */
public abstract class AnnotationClassTemplate extends ClassTemplate {

    protected final Class<? extends Annotation> annotationClass;

    protected AnnotationClassTemplate(String packageName, Class<? extends Annotation> annotationClass) {
        super(packageName);
        this.annotationClass = annotationClass;
    }
}
