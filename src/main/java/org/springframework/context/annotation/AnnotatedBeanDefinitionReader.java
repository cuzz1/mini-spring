package org.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Convenient adapter for programmatic registration of bean classes.
 *
 * <p>This is an alternative to {@link ClassPathBeanDefinitionScanner}, applying
 * the same resolution of annotations but for explicitly registered classes only.
 *
 * @author cuzz
 * @date 2022/3/3 17:40
 * @see AnnotationConfigApplicationContext#register
 */
public class AnnotatedBeanDefinitionReader {

    public static final String CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME =
            "org.springframework.context.annotation.internalConfigurationAnnotationProcessor";

    private final BeanDefinitionRegistry registry;

    public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        // 注册后置处理器
        registerAnnotationConfigProcessors();
    }

    public final BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }


    /**
     * Register one or more component classes to be processed.
     * <p>Calls to {@code register} are idempotent; adding the same
     * component class more than once has no additional effect.
     *
     * @param componentClasses one or more component classes,
     *                         e.g. {@link Configuration @Configuration} classes
     */
    public void register(Class<?>... componentClasses) {
        for (Class<?> componentClass : componentClasses) {
            registerBean(componentClass);
        }
    }

    /**
     * Register a bean from the given bean class, deriving its metadata from
     * class-declared annotations.
     *
     * @param beanClass the class of the bean
     */
    public void registerBean(Class<?> beanClass) {
        doRegisterBean(beanClass);
    }

    private void doRegisterBean(Class<?> beanClass) {
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedBeanDefinition(beanClass);

        AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
        if (!metadata.hasMetaAnnotation(Configuration.class.getName())) {
              throw new BeansException("Not Configuration Class: " + beanClass.getSimpleName());
        }

        // Configuration annotation = beanClass.getAnnotation(Configuration.class);
        // if (annotation == null) {
        //     throw new BeansException("Not Configuration Class: " + beanClass.getSimpleName());
        // }

        String beanName = StrUtil.lowerFirst(beanClass.getSimpleName());

        registry.registerBeanDefinition(beanName, annotatedBeanDefinition);
    }

    private void registerAnnotationConfigProcessors() {
        registry.registerBeanDefinition(CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME, new BeanDefinition(ConfigurationClassPostProcessor.class));

    }


}
