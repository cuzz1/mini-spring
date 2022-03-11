package org.springframework.core.type.classreading;

import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;

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
}
