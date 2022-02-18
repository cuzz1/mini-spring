package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.service.AwareService;
import org.springframework.test.ioc.service.HelloService;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * @author cuzz
 * @date 2022/2/18 22:38
 */
public class AwareInterfaceTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        AwareService awareService = applicationContext.getBean("awareService", AwareService.class);
        assertThat(awareService.getApplicationContext()).isNotNull();
        assertThat(awareService.getBeanFactory()).isNotNull();

        Map<String, HelloService> beansOfType = awareService.getApplicationContext().getBeansOfType(HelloService.class);
        System.out.println(beansOfType);
    }
}
