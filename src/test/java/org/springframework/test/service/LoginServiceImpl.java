package org.springframework.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cuzz
 * @date 2022/2/22 23:06
 */
@Component
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserService userService;

    @Override
    public void login(String name) {
        userService.checkUser(name);
        System.out.println("### " + name + " login...");
    }
}
