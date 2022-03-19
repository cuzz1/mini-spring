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

    /**
     * 包含组合注解
     */
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

    /**
     * 比如我们想获取@Component中的属性，他先找@Component得所有属性，然后他会找@Service的属性（@Service包含@Component），然后用@Service中的属性覆盖@Component中的
     * @param targetAnnotationType
     * @return
     */
    @Override
    public Map<String, Object> getAnnotationAttributes(Class<? extends Annotation> targetAnnotationType) {
        Map<String, Object> annotationValueMap = AnnotationUtil.getAnnotationValueMap(getIntrospectedClass(), targetAnnotationType);
        for (Annotation annotation : annotations) {
            // 不是本身这个注解，并且这个注解包含想要选择的注解
            if (annotation.annotationType() != targetAnnotationType && annotation.annotationType().isAnnotationPresent(targetAnnotationType)) {
                Map<String, Object> annotationValueMap1 = AnnotationUtil.getAnnotationValueMap(getIntrospectedClass(), annotation.annotationType());
                // 覆盖原来的属性
                for (Map.Entry<String, Object> entry : annotationValueMap1.entrySet()) {
                    if (annotationValueMap.containsKey(entry.getKey())) {
                        annotationValueMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return annotationValueMap;
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
