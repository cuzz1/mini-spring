package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author cuzz
 * @date 2022/3/7 21:37
 */
public class AnnotatedBeanDefinition extends BeanDefinition {
    private AnnotationMetadata metadata;

    public AnnotatedBeanDefinition(Class<?> beanClass) {
        super(beanClass);
        this.metadata = AnnotationMetadata.introspect(beanClass);
    }


    public AnnotationMetadata getMetadata() {
        return metadata;
    }
}
