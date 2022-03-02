package org.springframework.test.service.ab;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");
        A a = applicationContext.getBean(A.class);
        a.funcA();

    }
}