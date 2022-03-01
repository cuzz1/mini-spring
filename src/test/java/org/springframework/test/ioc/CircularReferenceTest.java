package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.A;
import org.springframework.test.bean.B;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author cuzz
 * @date 2022/3/1 11:06
 */
public class CircularReferenceTest {

    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference.xml");
        System.out.println(applicationContext);
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);

        assertThat(b.getA() == a).isTrue();
    }
}
