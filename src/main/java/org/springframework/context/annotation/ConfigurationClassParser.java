package org.springframework.context.annotation;

import org.springframework.beans.factory.annotation.ComponentScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.List;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/9 12:03
 */
public class ConfigurationClassParser {
    private final DefaultListableBeanFactory registry;

    public ConfigurationClassParser(BeanDefinitionRegistry registry) {
        this.registry = (DefaultListableBeanFactory) registry;
    }

    public void parse(Set<BeanDefinition> configCandidates) {
        for (BeanDefinition bd : configCandidates) {
            processConfigurationClass(new ConfigurationClass(bd));
        }
    }

    private void parse(List<BeanDefinition> configCandidates) {
        for (BeanDefinition bd : configCandidates) {
            processConfigurationClass(new ConfigurationClass(bd));
        }
    }

    /**
     * ConfigurationClass 是一个配置类
     *
     * @param configurationClass
     */
    private void processConfigurationClass(ConfigurationClass configurationClass) {
        // TODO
        doProcessConfigurationClass(configurationClass);
    }

    private void doProcessConfigurationClass(ConfigurationClass configurationClass) {
        BeanDefinition beanDefinition = configurationClass.getBeanDefinition();
        Class<?> beanClass = beanDefinition.getBeanClass();
        ComponentScan componentScan = beanClass.getAnnotation(ComponentScan.class);

        if (componentScan != null) {
            // 获取扫描的包
            String[] basePackages = componentScan.basePackages();
            ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(this.registry);
            scanner.doScan(basePackages);
        }

    }
}
