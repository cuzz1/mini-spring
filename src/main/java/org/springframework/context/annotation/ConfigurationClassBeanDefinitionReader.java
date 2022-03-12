package org.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;
import org.springframework.core.type.MethodMetadata;

import java.util.Set;

/**
 * Reads a given fully-populated set of ConfigurationClass instances, registering bean
 * definitions with the given {@link BeanDefinitionRegistry} based on its contents.
 * <p>
 * {@link Resource}.
 *
 * @author cuzz
 * @date 2022/3/12 18:22
 */
public class ConfigurationClassBeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    public ConfigurationClassBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }


    public void loadBeanDefinitions(Set<ConfigurationClass> configClasses) {
        for (ConfigurationClass configClass : configClasses) {
            loadBeanDefinitionsForConfigurationClass(configClass);
        }
    }

    /**
     * Read a particular {@link ConfigurationClass}, registering bean definitions
     * for the class itself and all of its {@link Bean} methods.
     */
    private void loadBeanDefinitionsForConfigurationClass(
            ConfigurationClass configClass) {

        for (BeanMethod beanMethod : configClass.getBeanMethods()) {
            loadBeanDefinitionsForBeanMethod(beanMethod);
        }

    }

    private void loadBeanDefinitionsForBeanMethod(BeanMethod beanMethod) {

        ConfigurationClass configClass = beanMethod.getConfigurationClass();

        MethodMetadata methodMetadata = beanMethod.getMetadata();

        String methodName = methodMetadata.getMethodName();

        BeanDefinition beanDefToRegister = new BeanDefinition(methodMetadata.getReturnType());

        this.registry.registerBeanDefinition(StrUtil.lowerFirst(methodName), beanDefToRegister);

    }


}