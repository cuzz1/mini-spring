package org.springframework.core.type;

import java.lang.annotation.Annotation;

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
     * Determine whether the underlying class has an annotation that is itself
     * annotated with the meta-annotation of the given type.
     *
     * @return {@code true} if a matching meta-annotation is present
     */
    boolean hasMetaAnnotation(Class<? extends Annotation> annotationType);

    <A extends Annotation> A getAnnotation(Class<A> annotationType);








}
