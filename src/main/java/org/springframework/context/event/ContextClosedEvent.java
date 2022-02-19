package org.springframework.context.event;

import org.springframework.context.ApplicationContext;

/**
 * @author cuzz
 * @date 2022/2/19 15:28
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
