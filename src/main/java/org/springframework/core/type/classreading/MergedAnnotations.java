package org.springframework.core.type.classreading;

import jdk.internal.jline.internal.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.function.Predicate;

/**
 * @author cuzz
 * @date 2022/3/10 21:48
 */
public interface MergedAnnotations extends Iterable<MergedAnnotation<Annotation>> {



    /**
     * Determine if the specified annotation is either directly present or
     * meta-present.
     * <p>Equivalent to calling {@code get(annotationType).isPresent()}.
     * @param annotationType the annotation type to check
     * @return {@code true} if the annotation is present
     */
    <A extends Annotation> boolean isPresent(Class<A> annotationType);


    /**
     * Get the {@linkplain MergedAnnotationSelectors#nearest() nearest} matching
     * annotation or meta-annotation of the specified type, or
     * {@link MergedAnnotation#missing()} if none is present.
     * @param annotationType the annotation type to get
     * @return a {@link MergedAnnotation} instance
     */
    <A extends Annotation> MergedAnnotation<A> get(Class<A> annotationType);


    /**
     * Get the {@linkplain MergedAnnotationSelectors#nearest() nearest} matching
     * annotation or meta-annotation of the specified type, or
     * {@link MergedAnnotation#missing()} if none is present.
     * @param annotationType the fully qualified class name of the annotation type
     * to get
     * @param predicate a predicate that must match, or {@code null} if only
     * type matching is required
     * @return a {@link MergedAnnotation} instance
     * @see MergedAnnotationPredicates
     */
    <A extends Annotation> MergedAnnotation<A> get(String annotationType,
                                                   @Nullable Predicate<? super MergedAnnotation<A>> predicate);


    public static MergedAnnotations from(AnnotatedElement element) {
        // TODO
        return new TypeMappedAnnotations(element);
    }
}
