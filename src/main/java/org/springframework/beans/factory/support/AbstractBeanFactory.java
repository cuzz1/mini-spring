package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuzz
 * @date 2022/2/13 14:13
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /**
     *
     */
    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是FactoryBean，从FactoryBean#getObject中创建Bean
            return getObjectForBeanInstance(sharedInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition);
        return getObjectForBeanInstance(bean, name);
    }

    /**
     * 如果是FactoryBean，从FactoryBean#getObject中创建bean
     *
     * @param beanInstance
     * @param beanName
     * @return
     */
    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        Object object = beanInstance;
        if (beanInstance instanceof FactoryBean) {
            FactoryBean factoryBean =  (FactoryBean) beanInstance;
            try {
                // singleton从缓存中获取
                if (factoryBean.isSingleton()) {
                    // 先从缓存中获取
                    object = factoryBeanObjectCache.get(beanName);
                    if (object == null) {
                        object = factoryBean.getObject();
                        factoryBeanObjectCache .put(beanName, object);
                    }
                } else {
                    // prototype每次新创建
                    object = factoryBean.getObject();
                }

            } catch (Exception e) {
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
            }
        }
        return object;
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return ((T) getBean(name));
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        // 有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
