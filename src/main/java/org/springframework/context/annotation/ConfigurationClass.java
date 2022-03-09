package org.springframework.context.annotation;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author cuzz
 * @date 2022/3/8 22:43
 */
public class ConfigurationClass {

    private final BeanDefinition beanDefinition;

    public ConfigurationClass(BeanDefinition beanDefinition) {
        this.beanDefinition = beanDefinition;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }
}
