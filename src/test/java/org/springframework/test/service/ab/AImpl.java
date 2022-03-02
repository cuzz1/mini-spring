package org.springframework.test.service.ab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cuzz
 * @date 2022/3/2 21:43
 */
@Component
public class AImpl implements A{

    @Autowired
    private B b;

    @Override
    public void funcA() {
        System.out.println("funcA");

    }
}
