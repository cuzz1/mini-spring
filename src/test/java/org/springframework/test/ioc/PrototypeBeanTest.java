package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author cuzz
 * @date 2022/2/19 11:57
 */
public class PrototypeBeanTest {
    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");
        Car singletonCar = applicationContext.getBean("singletonCar", Car.class);
        Car singletonCar2 = applicationContext.getBean("singletonCar", Car.class);
        assertThat(singletonCar == singletonCar2).isTrue();


        Car prototypeCar = applicationContext.getBean("prototypeCar", Car.class);
        Car prototypeCar2 = applicationContext.getBean("prototypeCar", Car.class);
        assertThat(prototypeCar != prototypeCar2).isTrue();
    }
}

