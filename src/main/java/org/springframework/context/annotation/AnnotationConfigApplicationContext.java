package org.springframework.context.annotation;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @author cuzz
 * @date 2022/3/3 15:49
 */
public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {

    private final AnnotatedBeanDefinitionReader reader;

    private final ClassPathBeanDefinitionScanner scanner;

    /**
     * Create a new AnnotationConfigApplicationContext that needs to be populated
     * through {@link #register} calls and then manually {@linkplain #refresh refreshed}.
     */
    public AnnotationConfigApplicationContext() {
        // 后置处理器会在AnnotatedBeanDefinitionReader构造器中注册
        this.reader = new AnnotatedBeanDefinitionReader(this);
        this.scanner = new ClassPathBeanDefinitionScanner(this);

    }

    public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
        this();
        register(componentClasses);
        refresh();
    }

    @Override
    public void register(Class<?>... componentClasses) {
        reader.register(componentClasses);
    }

    @Override
    public void scan(String... basePackages) {
        scanner.doScan(basePackages);
    }
}
