package org.springframework.core.type;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author cuzz
 * @date 2022/3/12 18:08
 */
public class StandardMethodMetadata implements MethodMetadata {

    private final Method introspectedMethod;

    public StandardMethodMetadata(Method introspectedMethod) {
        this.introspectedMethod = introspectedMethod;
    }

    @Override
    public String getMethodName() {
        return introspectedMethod.getName();
    }

    @Override
    public Class<?> getReturnType() {
        return introspectedMethod.getReturnType();
    }

    public Method getIntrospectedMethod() {
        return introspectedMethod;
    }

    @Override
    public boolean hasMetaAnnotation(Class<? extends Annotation> annotationType) {
        Annotation annotation = introspectedMethod.getAnnotation(annotationType);
        return annotation != null;
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        return introspectedMethod.getAnnotation(annotationType);

    }
}
