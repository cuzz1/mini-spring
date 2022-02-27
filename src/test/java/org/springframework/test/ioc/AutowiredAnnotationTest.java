package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.service.LoginService;

/**
 * @author cuzz
 * @date 2022/2/27 14:15
 */
public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");
        LoginService loginService = applicationContext.getBean(LoginService.class);
        loginService.login("cuzz");

    }
}
