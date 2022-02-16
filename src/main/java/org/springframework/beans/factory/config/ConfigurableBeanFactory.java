package org.springframework.beans.factory.config;

import org.springframework.beans.factory.xml.HierarchicalBeanFactory;

/**
 * @author cuzz
 * @date 2022/2/15 21:41
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
