package org.springframework.test.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.service.LoginService;

/**
 * @author cuzz
 * @date 2022/3/3 15:43
 */
public class ConfigurationTest {

    @Test
    public void testAnnotationConfigScan() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("org.springframework.test");
        applicationContext.refresh();
        LoginService bean = applicationContext.getBean(LoginService.class);
        System.out.println(bean);
    }


    @Test
    public void testAnnotationConfig() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = applicationContext.getBean(AppConfig.class);

        System.out.println(appConfig);

        A a = applicationContext.getBean(A.class);

        System.out.println(a);
    }

}
