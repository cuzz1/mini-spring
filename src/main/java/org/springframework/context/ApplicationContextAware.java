package org.springframework.context;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.BeansException;

/**
 * 实现该接口，能够感知所属的ApplicationContext
 *
 * @author cuzz
 * @date 2022/2/18 22:21
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
