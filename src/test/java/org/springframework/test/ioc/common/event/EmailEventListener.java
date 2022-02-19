package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationListener;

/**
 * @author cuzz
 * @date 2022/2/19 15:56
 */
public class EmailEventListener implements ApplicationListener<EmailEvent> {
    @Override
    public void onApplicationEvent(EmailEvent event) {
        EmailEvent.EmailDTO emailDTO = event.getEmailDTO();
        System.out.println("send a email, from: " + emailDTO.getFrom() + ", to: " + emailDTO.getTo() + ", content: " + emailDTO.getContent());
    }
}
