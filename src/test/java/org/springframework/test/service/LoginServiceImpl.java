package org.springframework.test.service;

import org.springframework.stereotype.Component;

/**
 * @author cuzz
 * @date 2022/2/22 23:06
 */
@Component
public class LoginServiceImpl implements LoginService{

    private String msg;

    @Override
    public void login(String name) {
        System.out.println("### " + name + " login...");
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
