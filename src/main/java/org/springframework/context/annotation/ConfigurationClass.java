package org.springframework.context.annotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.StandardAnnotationMetadata;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/8 22:43
 */
public class ConfigurationClass {

    private final AnnotationMetadata metadata;

    private final Class<?> configClass;

    private final String beanName;

    private final Set<BeanMethod> beanMethods = new LinkedHashSet<>();


    public ConfigurationClass(Class<?> configClass, AnnotationMetadata metadata, String beanName) {
        if (metadata == null) {
            metadata = new StandardAnnotationMetadata(configClass);
        }
        this.metadata = metadata;
        this.configClass = configClass;
        this.beanName = beanName;
    }


    public AnnotationMetadata getMetadata() {
        return metadata;
    }

    public String getBeanName() {
        return beanName;
    }

    public void addBeanMethod(BeanMethod method) {
        this.beanMethods.add(method);
    }

    public Set<BeanMethod> getBeanMethods() {
        return beanMethods;
    }

    public Class<?> getConfigClass() {
        return configClass;
    }
}
