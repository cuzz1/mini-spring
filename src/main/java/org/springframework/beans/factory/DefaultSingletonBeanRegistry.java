package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DisposableBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/2/13 13:58
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 一级缓存：用于存放完全初始化好的 bean，从该缓存中取出的 bean 可以直接使用
    private Map<String, Object> singletonObjects = new HashMap<>();

    // 二级缓存：提前曝光的单例对象的cache，存放原始的 bean 对象（尚未填充属性），用于解决循环依赖
    private Map<String, Object> earlySingletonObjects = new HashMap<>();

    // 三级缓存：单例对象工厂的cache，存放 bean 工厂对象，以便于后面扩展有机会创建代理对象，用于解决循环依赖
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();


    /**
     * 保存需要销毁的对象
     */
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 从三级缓存放进二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }
    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        singletonFactories.put(beanName, singletonFactory);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> beanNames = disposableBeans.keySet();
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
