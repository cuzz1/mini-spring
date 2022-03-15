package org.springframework.test.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cuzz
 * @date 2022/3/3 15:43
 */
public class ConfigurationTest {

    @Test
    public void testAnnotationConfigScan() throws Exception {
    }


    @Test
    public void testAnnotationConfig() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("name: " + beanName);
            System.out.println("bean: " + applicationContext.getBean(beanName));
            System.out.println("--------------------");
        }


    }

}
