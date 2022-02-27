package org.springframework.test.service;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;

/**
 * @author cuzz
 * @date 2022/2/27 14:11
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public boolean checkUser(String name) {
        System.out.println("check user name:" + name);
        return StrUtil.equals("cuzz", name);
    }
}
