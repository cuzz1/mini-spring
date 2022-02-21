package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author cuzz
 * @date 2022/2/19 13:29
 */
public class FactoryBeanTest {
    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        assertThat(person.getName().equals("My name is cuzz")).isTrue();
    }
}
