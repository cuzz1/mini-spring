package org.springframework.context;

import org.springframework.beans.factory.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author cuzz
 * @date 2022/2/17 20:02
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
