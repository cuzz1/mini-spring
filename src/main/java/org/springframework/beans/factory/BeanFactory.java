package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author cuzz
 * @date 2022/2/13 12:35
 */
public interface BeanFactory {

    /**
     * 获取 bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据名称和类型查找bean
     *
     * @param name
     * @param requireType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requireType) throws BeansException;
}
