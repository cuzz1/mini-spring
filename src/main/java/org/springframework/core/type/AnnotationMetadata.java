package org.springframework.core.type;

import org.springframework.core.type.classreading.StandardAnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/4 00:46
 */
public interface AnnotationMetadata extends ClassMetadata, AnnotatedTypeMetadata {

    static AnnotationMetadata introspect(Class<?> type) {
        return StandardAnnotationMetadata.from(type);
    }


    /**
     * Retrieve the method metadata for all methods that are annotated
     * (or meta-annotated) with the given annotation type.
     * <p>For any returned method, {@link MethodMetadata#isAnnotated} will
     * return {@code true} for the given annotation type.
     * <p>
     * 获取注解方法
     *
     * @param annotationType
     * @return a set of {@link MethodMetadata} for methods that have a matching
     * annotation. The return value will be an empty set if no methods match
     * the annotation type.
     */
    Set<MethodMetadata> getAnnotatedMethods(Class<? extends Annotation> annotationType);
}
