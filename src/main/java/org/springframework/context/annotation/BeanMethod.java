package org.springframework.context.annotation;

import org.springframework.core.type.MethodMetadata;

/**
 * @author cuzz
 * @date 2022/3/12 18:13
 */
public class BeanMethod {

    /**
     * 方法元信息
     */
    protected final MethodMetadata metadata;

    protected final ConfigurationClass configurationClass;

    public BeanMethod(MethodMetadata metadata, ConfigurationClass configurationClass) {
        this.metadata = metadata;
        this.configurationClass = configurationClass;
    }

    public MethodMetadata getMetadata() {
        return metadata;
    }

    public ConfigurationClass getConfigurationClass() {
        return configurationClass;
    }
}
