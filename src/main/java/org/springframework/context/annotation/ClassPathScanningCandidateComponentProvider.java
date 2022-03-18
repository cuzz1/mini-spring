package org.springframework.context.annotation;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ClassUtil;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/2/26 23:31
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        return scanCandidateComponents(basePackage);

    }

    private Set<BeanDefinition> scanCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();
        // 扫描有org.springframework.stereotype.Component注解的类
        Set<Class<?>> classes = ClassUtil.scanPackage(basePackage, clazz -> {
            Annotation[] annotations = AnnotationUtil.getAnnotations(clazz, true);
            for (Annotation annotation : annotations) {
                // 这个Annotation是反射包装过后的
                if (annotation.annotationType() == Component.class) {
                    return true;
                }
            }
            return false;
        });
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new AnnotatedBeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
