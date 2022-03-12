package org.springframework.core.type.classreading;

import cn.hutool.core.annotation.AnnotationUtil;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/10 21:43
 */
public class StandardAnnotationMetadata extends StandardClassMetadata implements AnnotationMetadata {

    private final Annotation[] annotations;

    public StandardAnnotationMetadata(Class<?> introspectedClass) {
        super(introspectedClass);
        annotations = introspectedClass.getAnnotations();
    }

    public static AnnotationMetadata from(Class<?> type) {
        return new StandardAnnotationMetadata(type);
    }

    @Override
    public boolean hasMetaAnnotation(String annotationName) {
        for (Annotation ann : this.annotations) {
            if (ann.annotationType().getName().equals(annotationName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasMetaAnnotation(Class<? extends Annotation> annotationType) {
        return AnnotationUtil.hasAnnotation(getIntrospectedClass(), annotationType);
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        return getIntrospectedClass().getAnnotation(annotationType);
    }

    @Override
    public boolean hasAnnotatedMethods(String annotationName) {
        return false;
    }

    @Override
    public Set<MethodMetadata> getAnnotatedMethods(String annotationName) {
        return null;
    }

    @Override
    public Set<MethodMetadata> getAnnotatedMethods(Class<? extends Annotation> annotationType) {

        Set<MethodMetadata> methodMetadataSet = new LinkedHashSet<>();

        Method[] methods = getIntrospectedClass().getDeclaredMethods();
        for (Method method : methods) {
            if (AnnotationUtil.hasAnnotation(method, annotationType)) {
                methodMetadataSet.add(new StandardMethodMetadata(method));
            }
        }
        return methodMetadataSet;
    }
}
