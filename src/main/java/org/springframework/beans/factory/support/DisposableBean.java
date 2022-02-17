package org.springframework.beans.factory.support;

/**
 * @author cuzz
 * @date 2022/2/17 21:31
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
