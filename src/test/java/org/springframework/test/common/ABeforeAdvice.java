package org.springframework.test.common;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class ABeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before " + "[" + method.getName() + "]");
    }
}
