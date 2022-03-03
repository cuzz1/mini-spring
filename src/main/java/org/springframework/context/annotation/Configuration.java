package org.springframework.context.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cuzz
 * @date 2022/3/03 23:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Configuration {
    /**
     * Explicitly specify the name of the Spring bean definition associated with the
     * {@code @Configuration} class. If left unspecified (the common case), a bean
     * name will be automatically generated.
     * <p>The custom name applies only if the {@code @Configuration} class is picked
     * up via component scanning or supplied directly to an
     * {@link AnnotationConfigApplicationContext}. If the {@code @Configuration} class
     * is registered as a traditional XML bean definition, the name/id of the bean
     * element will take precedence.
     *
     * @return the explicit component name, if any (or empty String otherwise)
     * @see AnnotationBeanNameGenerator
     */
    String value() default "";
}
