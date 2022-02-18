package org.springframework.context.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author cuzz
 * @date 2022/2/17 20:35
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    /**
     * 创建BeanFactory并加载BeanDefinition
     *
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 加载BeanDefinition
     *
     * @param beanFactory
     * @throws BeansException
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    /**
     * 创建bean工厂
     *
     * @return
     */
    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }
}
