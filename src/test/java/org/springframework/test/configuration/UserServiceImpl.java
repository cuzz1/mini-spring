package org.springframework.test.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cuzz
 * @date 2022/3/16 22:20
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private Person person;

    @Override
    public String getUseName() {
        return person.getName();
    }
}
