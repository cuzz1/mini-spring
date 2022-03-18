package org.springframework.core.type.classreading;

import cn.hutool.core.annotation.AnnotationUtil;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/10 21:43
 */
public class StandardAnnotationMetadata extends StandardClassMetadata implements AnnotationMetadata {

    private final Annotation[] annotations;

    public StandardAnnotationMetadata(Class<?> introspectedClass) {
        super(introspectedClass);
        annotations = AnnotationUtil.getAnnotations(introspectedClass, true);
    }

    public static AnnotationMetadata from(Class<?> type) {
        return new StandardAnnotationMetadata(type);
    }


    @Override
    public boolean hasMetaAnnotation(Class<? extends Annotation> annotationType) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == annotationType) {
                return true;
            }
        }
        return false;
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == annotationType) {
                return (A) annotation;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> getAnnotationAttributes(Class<? extends Annotation> annotationType) {
        return AnnotationUtil.getAnnotationValueMap(getIntrospectedClass(),annotationType);



    }

    public Map<String, Object> getAnnotationAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        for (Annotation annotation : annotations) {
            Map<String, Object> annotationValueMap = AnnotationUtil.getAnnotationValueMap(getIntrospectedClass(), annotation.annotationType());
            for (Map.Entry<String, Object> entry : annotationValueMap.entrySet()) {
                // 如果包含这个key，判断一下是否为空
                if (attributes.containsKey(entry.getKey())) {
                    // TODO 这里需要处理一下防止覆盖
                    attributes.put(entry.getKey(), entry.getValue());
                } else {
                    attributes.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return attributes;
    }

    public Object getAnnotationAttribute(String key) {
        Map<String, Object> annotationAttributes = getAnnotationAttributes();
        return annotationAttributes.get(key);
    }


        @Override
    public Set<MethodMetadata> getAnnotatedMethods(Class<? extends Annotation> annotationType) {

        Set<MethodMetadata> methodMetadataSet = new LinkedHashSet<>();

        Method[] methods = getIntrospectedClass().getDeclaredMethods();
        for (Method method : methods) {
            if (AnnotationUtil.hasAnnotation(method, annotationType)) {
                methodMetadataSet.add(new StandardMethodMetadata(method));
            }
        }
        return methodMetadataSet;
    }
}
