package org.springframework.beans.factory;

/**
 * @author cuzz
 * @date 2022/2/17 21:30
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
