package org.springframework.beans.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanFactoryPostProcessor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 处理站位符配置
 *
 * @author cuzz
 * @date 2022/2/25 20:26
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String PLACEHOLDER_PREFIX = "${";

    public static final String PLACEHOLDER_SUFFIX = "}";

    private String location;

    public PropertyPlaceholderConfigurer() {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        try {
            Properties properties = loadProperties();

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                Object bean = beanFactory.getBean(beanDefinitionName);
                Map<String, Object> filedMap = BeanUtil.beanToMap(bean);
                for (Map.Entry<String, Object> entry : filedMap.entrySet()) {
                    Object value = entry.getValue();
                    String s = value.toString();
                    if (!s.startsWith(PLACEHOLDER_PREFIX) || !s.endsWith(PLACEHOLDER_SUFFIX)) {
                        continue;
                    }
                    String propertyKey = s.substring(PLACEHOLDER_PREFIX.length(), s.length() - PLACEHOLDER_SUFFIX.length());
                    Object propertyValue = properties.get(propertyKey);
                    if (propertyValue == null) {
                        throw new IllegalArgumentException("Not found this properties key: " + propertyKey);
                    }
                    ReflectUtil.setFieldValue(bean, entry.getKey(), propertyValue);
                }


            }
        } catch (Exception e) {
            throw new BeansException("PropertyPlaceholderConfigurer error",e);
        }

    }

    private Properties loadProperties() throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource(location);
        Properties properties = new Properties();
        InputStream inputStream = resource.getInputStream();
        properties.load(inputStream);
        return properties;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
