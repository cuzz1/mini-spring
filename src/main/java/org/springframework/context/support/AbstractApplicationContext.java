package org.springframework.context.support;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanFactoryPostProcessor;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用上下文
 *
 * @author cuzz
 * @date 2022/2/17 20:06
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        // 创建BeanFactory,并加载BeanDefinition
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 添加ApplicationContextAwareProcessor，让继承ApplicationContextAware的Bean能感知Bean
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 在bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessor(beanFactory);

        // BeanPostProcess需要提前与其他bean实例化之前注册
        registerBeanPostProcessors(beanFactory);

        // 提前实例化单例Bean
        beanFactory.preInstantiateSingletons();

    }

    /**
     * @param beanFactory
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    /**
     * 在bean实例化之前，执行BeanFactoryPostProcessor
     *
     * @param beanFactory
     */
    private void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 获取BeanFactory
     *
     * @return
     */
    public abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 创建BeanFactory，并加载BeanDefinition
     *
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;


    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 为了确保销毁方法在虚拟机关闭之前执行，向虚拟机中注册一个钩子方法
     */
    public void registerShutdownHook() {
        Thread shutdownHook = new Thread() {
            public void run() {
                doClose();
            }
        };
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public void close() {
        doClose();
    }

    protected void doClose() {
        destroyBeans();
    }

    private void destroyBeans() {
        getBeanFactory().destroySingletons();
    }
}
