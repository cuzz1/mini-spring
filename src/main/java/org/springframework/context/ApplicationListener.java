package org.springframework.context;

import java.util.EventListener;

/**
 * 监听器
 *
 * @author cuzz
 * @date 2022/2/19 14:30
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
