package org.springframework.test.service;

/**
 * @author cuzz
 * @date 2022/2/22 23:05
 */
public interface LoginService {

    String getMsg();

    void login(String name);
}
