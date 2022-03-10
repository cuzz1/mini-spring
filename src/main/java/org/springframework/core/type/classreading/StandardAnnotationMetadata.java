package org.springframework.core.type.classreading;

import org.springframework.core.type.AnnotationMetadata;

/**
 * @author cuzz
 * @date 2022/3/10 21:43
 */
public class StandardAnnotationMetadata extends StandardClassMetadata implements AnnotationMetadata {

    private final MergedAnnotations mergedAnnotations;

    public StandardAnnotationMetadata(Class<?> introspectedClass) {
        super(introspectedClass);
        this.mergedAnnotations = MergedAnnotations.from(introspectedClass);
    }

    public static AnnotationMetadata from(Class<?> type) {
        return new StandardAnnotationMetadata(type);
    }

    @Override
    public MergedAnnotations getAnnotations() {
        return this.mergedAnnotations;
    }
}
