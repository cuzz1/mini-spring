package org.springframework.beans.factory.config;

/**
 * @author cuzz
 * @date 2022/3/12 10:53
 */
public class BeanDefinitionHolder {

    private final BeanDefinition beanDefinition;

    private final String beanName;

    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
    }

    public BeanDefinition getBeanDefinition() {
        return beanDefinition;
    }

    public String getBeanName() {
        return beanName;
    }
}
