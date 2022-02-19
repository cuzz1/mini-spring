package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class EmailEvent extends ApplicationContextEvent {

    private final EmailDTO emailDTO;

    public EmailEvent(ApplicationContext source, EmailDTO emailDTO) {
        super(source);
        this.emailDTO = emailDTO;
    }

    public EmailDTO getEmailDTO() {
        return emailDTO;
    }

    public static class EmailDTO {

        private String from;
        private String to;
        private String content;

        public EmailDTO() {
        }

        public EmailDTO(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}