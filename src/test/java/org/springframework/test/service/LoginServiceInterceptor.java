package org.springframework.test.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author cuzz
 * @date 2022/2/22 23:08
 */
public class LoginServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Do something before login...");
        Object result = invocation.proceed();
        System.out.println("Do something after login...");
        return result;

    }
}
