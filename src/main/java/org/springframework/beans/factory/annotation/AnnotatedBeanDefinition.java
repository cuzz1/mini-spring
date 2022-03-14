package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @author cuzz
 * @date 2022/3/7 21:37
 */
public class AnnotatedBeanDefinition extends BeanDefinition {

    private AnnotationMetadata metadata;
    private MethodMetadata factoryMethodMetadata;

    public AnnotatedBeanDefinition(Class<?> beanClass) {
        super(beanClass);
        this.metadata = AnnotationMetadata.introspect(beanClass);
    }

    public AnnotatedBeanDefinition(Class beanClass, AnnotationMetadata metadata, MethodMetadata factoryMethodMetadata) {
        super(beanClass);
        this.metadata = metadata;
        this.factoryMethodMetadata = factoryMethodMetadata;
    }


    public AnnotationMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AnnotationMetadata metadata) {
        this.metadata = metadata;
    }

    public MethodMetadata getFactoryMethodMetadata() {
        return factoryMethodMetadata;
    }

    public void setFactoryMethodMetadata(MethodMetadata factoryMethodMetadata) {
        this.factoryMethodMetadata = factoryMethodMetadata;
    }
}
