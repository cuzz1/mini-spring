package org.springframework.core.type.classreading;

import java.lang.annotation.Annotation;

/**
 * @author cuzz
 * @date 2022/3/10 22:22
 */
public interface MergedAnnotation<A extends Annotation> {

    /**
     * Get the {@code Class} reference for the actual annotation type.
     * @return the annotation type
     */
    Class<A> getType();
    /**
     * Determine if the annotation is meta-present on the source.
     * <p>A meta-present annotation is an annotation that the user hasn't
     * explicitly declared, but has been used as a meta-annotation somewhere in
     * the annotation hierarchy.
     * @return {@code true} if the annotation is meta-present
     */
    boolean isMetaPresent();

    boolean isPresent();
}
