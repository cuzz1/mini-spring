package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 提供基本的监听器注册工具方法（注册和移除监听器）
 *
 * @author cuzz
 * @date 2022/2/19 14:36
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加监听器
     *
     * @param listener
     */
    void addApplicationListener(ApplicationListener<ApplicationEvent> listener);

    /**
     * 移除监听器
     *
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<ApplicationEvent> listener);

    /**
     * 广播事件
     *
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
