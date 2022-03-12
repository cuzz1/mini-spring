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
     * Determine whether the underlying class has an annotation that is itself
     * annotated with the meta-annotation of the given type.
     *
     * @param metaAnnotationName the fully qualified class name of the
     *                           meta-annotation type to look for
     * @return {@code true} if a matching meta-annotation is present
     */
    boolean hasMetaAnnotation(String metaAnnotationName);


    /**
     * Determine whether the underlying class has an annotation that is itself
     * annotated with the meta-annotation of the given type.
     *
     * @return {@code true} if a matching meta-annotation is present
     */
    boolean hasMetaAnnotation(Class<? extends Annotation> annotationType);

    <A extends Annotation> A getAnnotation(Class<A> annotationType);


    /**
     * Determine whether the underlying class has any methods that are
     * annotated (or meta-annotated) with the given annotation type.
     * <p>
     * 是否只有一个注解
     *
     * @param annotationName the fully qualified class name of the annotation
     *                       type to look for
     */
    boolean hasAnnotatedMethods(String annotationName);

    /**
     * Retrieve the method metadata for all methods that are annotated
     * (or meta-annotated) with the given annotation type.
     * <p>For any returned method, {@link MethodMetadata#isAnnotated} will
     * return {@code true} for the given annotation type.
     * <p>
     * 获取注解方法
     *
     * @param annotationName the fully qualified class name of the annotation
     *                       type to look for
     * @return a set of {@link MethodMetadata} for methods that have a matching
     * annotation. The return value will be an empty set if no methods match
     * the annotation type.
     */
    Set<MethodMetadata> getAnnotatedMethods(String annotationName);


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
