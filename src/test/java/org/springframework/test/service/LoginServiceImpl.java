package org.springframework.test.service;

/**
 * @author cuzz
 * @date 2022/2/22 23:06
 */
public class LoginServiceImpl implements LoginService{
    @Override
    public void login(String name) {
        System.out.println("### " + name + " login...");
    }
}
