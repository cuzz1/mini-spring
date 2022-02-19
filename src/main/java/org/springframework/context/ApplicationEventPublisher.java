package org.springframework.context;

import org.springframework.context.ApplicationEvent;

/**
 * 事件发布责接口
 *
 * @author cuzz
 * @date 2022/2/19 14:26
 */
public interface ApplicationEventPublisher {
    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
