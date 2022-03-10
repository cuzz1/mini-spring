package org.springframework.core.type;

import org.springframework.core.type.classreading.MergedAnnotation;
import org.springframework.core.type.classreading.StandardAnnotationMetadata;

/**
 * @author cuzz
 * @date 2022/3/4 00:46
 */
public interface AnnotationMetadata extends ClassMetadata, AnnotatedTypeMetadata {


    static AnnotationMetadata introspect(Class<?> type) {
        return StandardAnnotationMetadata.from(type);
    }


    default boolean hasMetaAnnotation(String metaAnnotationName) {
        return getAnnotations().get(metaAnnotationName,
                MergedAnnotation::isMetaPresent).isPresent();
    }
}
