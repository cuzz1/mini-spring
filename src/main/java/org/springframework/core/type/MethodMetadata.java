package org.springframework.core.type;

/**
 * @author cuzz
 * @date 2022/3/10 21:04
 */
public interface MethodMetadata extends AnnotatedTypeMetadata {

    String getMethodName();


    Class<?> getReturnType();
}
