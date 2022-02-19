package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.common.event.EmailEvent;

/**
 * @author cuzz
 * @date 2022/2/19 16:01
 */
public class EventAndEventListenerTest {
    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new EmailEvent(applicationContext, new EmailEvent.EmailDTO("cuzz@gmailc.om", "cuzz@163.com", "Hello World")));

        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
    }
}
