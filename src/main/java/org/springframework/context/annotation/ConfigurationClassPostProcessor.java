package org.springframework.context.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuzz
 * @date 2022/3/3 22:14
 */
public class ConfigurationClassPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private BeanDefinitionRegistry registry;

    /**
     * 1、完成了扫描
     * 2、完成对配置的定义
     * 3、完成Import的处理
     * 4、ImportResource
     * 5、@Bean注册
     * 6、@PropertySource
     *
     * @param registry the bean definition registry used by the application context
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        this.registry = registry;
        //
        processConfigBeanDefinitions(registry);

    }

    /**
     * Prepare the Configuration classes for servicing bean requests at runtime
     * by replacing them with CGLIB-enhanced subclasses.
     *
     * @param registry
     */
    private void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
        ConfigurationClassParser parser = new ConfigurationClassParser(registry);

        Set<BeanDefinition> configCandidates = new HashSet<>();

        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDef = registry.getBeanDefinition(beanName);
            boolean b = checkConfigurationClassCandidate(beanDef);
            if (b) {
                configCandidates.add(beanDef);
            }
        }
        parser.parse(configCandidates);
    }

    private void parse(List<BeanDefinition> configCandidates) {
        for (BeanDefinition bd : configCandidates) {
            // Class<?> beanClass = bd.getBeanClass();
            // Method[] methods = beanClass.getDeclaredMethods();
            // // @bean注解处理
            // for (Method method : methods) {
            //     Bean beanAnnotation = method.getAnnotation(Bean.class);
            //     if (beanAnnotation == null) {
            //         continue;
            //     }
            //     String name = StrUtil.lowerFirst(method.getName());
            //     Class<?> returnType = method.getReturnType();
            //     registry.registerBeanDefinition(name, new BeanDefinition(returnType));
            // }
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

    }

    /**
     * 找到符合配置类
     *
     * @param beanDef
     * @return
     */
    private boolean checkConfigurationClassCandidate(BeanDefinition beanDef) {
        Annotation annotation = beanDef.getBeanClass().getAnnotation(Configuration.class);
        if (annotation != null) {
            return true;
        }
        return false;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

}