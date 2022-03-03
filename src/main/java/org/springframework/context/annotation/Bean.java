package org.springframework.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cuzz
 * @date 2022/3/03 23:41
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
    /**
     * The name of this bean, or if several names, a primary bean name plus aliases.
     * <p>If left unspecified, the name of the bean is the name of the annotated method.
     * If specified, the method name is ignored.
     * <p>The bean name and aliases may also be configured via the {@link #value}
     * attribute if no other attributes are declared.
     *
     * @see #value
     */
    String[] name() default {};

    /**
     * The optional name of a method to call on the bean instance during initialization.
     * Not commonly used, given that the method may be called programmatically directly
     * within the body of a Bean-annotated method.
     * <p>The default value is {@code ""}, indicating no init method to be called.
     *
     * @see org.springframework.beans.factory.InitializingBean
     * @see org.springframework.context.ConfigurableApplicationContext#refresh()
     */
    // String initMethod() default "";

    /**
     * The optional name of a method to call on the bean instance upon closing the
     * application context, for example a {@code close()} method on a JDBC
     * {@code DataSource} implementation, or a Hibernate {@code SessionFactory} object.
     * The method must have no arguments but may throw any exception.
     * <p>As a convenience to the user, the container will attempt to infer a destroy
     * method against an object returned from the {@code @Bean} method. For example, given
     * an {@code @Bean} method returning an Apache Commons DBCP {@code BasicDataSource},
     * the container will notice the {@code close()} method available on that object and
     * automatically register it as the {@code destroyMethod}. This 'destroy method
     * inference' is currently limited to detecting only public, no-arg methods named
     * 'close' or 'shutdown'. The method may be declared at any level of the inheritance
     * hierarchy and will be detected regardless of the return type of the {@code @Bean}
     * method (i.e., detection occurs reflectively against the bean instance itself at
     * creation time).
     * <p>To disable destroy method inference for a particular {@code @Bean}, specify an
     * empty string as the value, e.g. {@code @Bean(destroyMethod="")}. Note that the
     * {@link org.springframework.beans.factory.DisposableBean} callback interface will
     * nevertheless get detected and the corresponding destroy method invoked: In other
     * words, {@code destroyMethod=""} only affects custom close/shutdown methods and
     * {@link java.io.Closeable}/{@link java.lang.AutoCloseable} declared close methods.
     * <p>Note: Only invoked on beans whose lifecycle is under the full control of the
     * factory, which is always the case for singletons but not guaranteed for any
     * other scope.
     *
     * @see org.springframework.beans.factory.DisposableBean
     * @see org.springframework.context.ConfigurableApplicationContext#close()
     */
    // String destroyMethod() default AbstractBeanDefinition.INFER_METHOD;
}
