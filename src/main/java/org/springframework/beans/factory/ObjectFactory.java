package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author cuzz
 * @date 2022/3/1 11:29
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
