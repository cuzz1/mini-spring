package org.springframework.test.configuration;

import cn.hutool.core.annotation.AnnotationUtil;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author cuzz
 * @date 2022/3/3 15:43
 */
public class ConfigurationTest {

    @Test
    public void test() throws Exception {

    }


    @Test
    public void testAnnotationConfig() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<String, Car> beansMap = applicationContext.getBeansOfType(Car.class);
        for (Map.Entry<String, Car> stringCarEntry : beansMap.entrySet()) {
            System.out.println("beanName: " + stringCarEntry.getKey() + " bean: " + stringCarEntry.getValue());
        }

        System.out.println("-------------------");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName: " + beanName + " bean: " + applicationContext.getBean(beanName));
        }

        applicationContext.close();
    }

}
