package org.springframework.beans.factory.config;

/**
 * 单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void addSingleton(String beanName, Object singletonObject);

}
