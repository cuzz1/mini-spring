package org.springframework.context.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author cuzz
 * @date 2022/2/17 20:41
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 初始化 beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }

    }

    protected abstract String[] getConfigLocations();
}
