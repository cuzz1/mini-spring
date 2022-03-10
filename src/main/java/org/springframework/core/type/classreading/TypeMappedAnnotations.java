package org.springframework.core.type.classreading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author cuzz
 * @date 2022/3/10 22:02
 */
final class TypeMappedAnnotations implements MergedAnnotations {

    private final AnnotatedElement element;

    private final Annotation[] annotations;


    public TypeMappedAnnotations(AnnotatedElement element, Annotation[] annotations) {
        this.element = element;
        this.annotations = annotations;
    }

    public TypeMappedAnnotations(AnnotatedElement element) {
        // TODO
        this.element = element;
        this.annotations = null;
    }

    @Override
    public <A extends Annotation> boolean isPresent(Class<A> annotationType) {
        return false;
    }

    @Override
    public <A extends Annotation> MergedAnnotation<A> get(Class<A> annotationType) {
        return null;
    }

    @Override
    public <A extends Annotation> MergedAnnotation<A> get(String annotationType, Predicate<? super MergedAnnotation<A>> predicate) {
        return null;
    }

    @Override
    public Iterator<MergedAnnotation<Annotation>> iterator() {
        return null;
    }


    // @Override
    // public Spliterator<MergedAnnotation<Annotation>> spliterator() {
    // }
}
