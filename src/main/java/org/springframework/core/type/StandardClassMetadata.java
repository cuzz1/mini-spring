package org.springframework.core.type;

import cn.hutool.core.lang.Assert;

/**
 * @author cuzz
 * @date 2022/3/10 21:29
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
