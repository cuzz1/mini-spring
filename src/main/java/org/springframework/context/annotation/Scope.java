package org.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @author cuzz
 * @date 2022/2/26 23:41
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {
    String value() default "singleton";
}
