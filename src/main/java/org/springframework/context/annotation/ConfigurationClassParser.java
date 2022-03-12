package org.springframework.context.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.ComponentScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/9 12:03
 */
public class ConfigurationClassParser {

    private final DefaultListableBeanFactory registry;

    private final Map<ConfigurationClass, ConfigurationClass> configurationClasses = new LinkedHashMap<>();

    public ConfigurationClassParser(BeanDefinitionRegistry registry) {
        this.registry = (DefaultListableBeanFactory) registry;
    }

    public void parse(Set<BeanDefinitionHolder> configCandidates) {
        for (BeanDefinitionHolder holder : configCandidates) {
            BeanDefinition bd = holder.getBeanDefinition();
            try {
                if (bd instanceof AnnotatedBeanDefinition) {
                    parse(bd.getBeanClass(), ((AnnotatedBeanDefinition) bd).getMetadata(), holder.getBeanName());
                } else {
                    parse(bd.getBeanClass(), null, holder.getBeanName());
                }
            } catch (Exception ex) {
                throw new BeansException("Failed to parse configuration class [" + bd.getBeanClassName() + "]", ex);
            }
        }
    }

    protected final void parse(Class<?> clazz, AnnotationMetadata metadata, String beanName) throws IOException {
        processConfigurationClass(new ConfigurationClass(clazz, metadata, beanName));
    }


    /**
     * ConfigurationClass 是一个配置类
     *
     * @param configurationClass
     */
    private void processConfigurationClass(ConfigurationClass configurationClass) {
        doProcessConfigurationClass(configurationClass);
        this.configurationClasses.put(configurationClass, configurationClass);
    }

    private void doProcessConfigurationClass(ConfigurationClass configurationClass) {

        AnnotationMetadata metadata = configurationClass.getMetadata();

        // Process any @ComponentScan annotations
        ComponentScan componentScan = metadata.getAnnotation(ComponentScan.class);
        if (componentScan != null) {
            // 获取扫描的包
            String[] basePackages = componentScan.basePackages();
            ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(this.registry);
            scanner.doScan(basePackages);
        }


        // Process individual @Bean methods
        Set<MethodMetadata> annotatedMethods = metadata.getAnnotatedMethods(Bean.class);
        for (MethodMetadata annotatedMethod : annotatedMethods) {
            configurationClass.addBeanMethod(new BeanMethod(annotatedMethod, configurationClass));
        }

    }

    public Set<ConfigurationClass> getConfigurationClasses() {
        return new LinkedHashSet<>(this.configurationClasses.keySet());
    }
}
