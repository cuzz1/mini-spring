package org.springframework.context;

import org.springframework.beans.BeansException;

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
