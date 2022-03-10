package org.springframework.core.type.classreading;

import java.lang.annotation.Annotation;

/**
 * @author cuzz
 * @date 2022/3/10 22:53
 */
public abstract class AbstractMergedAnnotation<A extends Annotation> implements MergedAnnotation<A> {

    @Override
    public Class<A> getType() {
        return null;
    }

    @Override
    public boolean isMetaPresent() {
        return false;
    }
}
