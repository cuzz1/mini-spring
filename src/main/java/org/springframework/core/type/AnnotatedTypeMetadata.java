package org.springframework.core.type;

import org.springframework.core.type.classreading.MergedAnnotations;

/**
 * Defines access to the annotations of a specific type ({@link AnnotationMetadata class}
 * or {@link MethodMetadata method}), in a form that does not necessarily require the
 * class-loading.
 * <p>
 *
 * @author cuzz
 * @date 2022/3/10 21:03
 */
public interface AnnotatedTypeMetadata {

    /**
     * Return annotation details based on the direct annotations of the
     * underlying element.
     * @return merged annotations based on the direct annotations
     * @since 5.2
     */
    MergedAnnotations getAnnotations();

}
