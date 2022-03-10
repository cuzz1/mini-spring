package org.springframework.core.type.classreading;

import cn.hutool.core.lang.Assert;
import org.springframework.core.type.ClassMetadata;

/**
 * @author cuzz
 * @date 2022/3/10 21:46
 */
public class StandardClassMetadata implements ClassMetadata {

    private final Class<?> introspectedClass;

    /**
     * Create a new StandardClassMetadata wrapper for the given Class.
     *
     * @param introspectedClass the Class to introspect
     * @deprecated since 5.2 in favor of {@link StandardAnnotationMetadata}
     */
    @Deprecated
    public StandardClassMetadata(Class<?> introspectedClass) {
        Assert.notNull(introspectedClass, "Class must not be null");
        this.introspectedClass = introspectedClass;
    }

    /**
     * Return the underlying Class.
     */
    public final Class<?> getIntrospectedClass() {
        return this.introspectedClass;
    }


    @Override
    public String getClassName() {
        return this.introspectedClass.getName();
    }

    @Override
    public boolean isInterface() {
        return this.introspectedClass.isInterface();
    }

    @Override
    public boolean isAnnotation() {
        return this.introspectedClass.isAnnotation();
    }
}
