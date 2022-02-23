package org.springframework.test.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.AdvisedSupport;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.TargetSource;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
import org.springframework.test.service.LoginService;
import org.springframework.test.service.LoginServiceImpl;
import org.springframework.test.service.LoginServiceInterceptor;

/**
 * @author cuzz
 * @date 2022/2/22 23:03
 */
public class DynamicProxyTest {

    AdvisedSupport advisedSupport;
    @Before
    public void init() throws Exception {
        LoginService loginService = new LoginServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(loginService);
        LoginServiceInterceptor methodInterceptor = new LoginServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.LoginService.login(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);


    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        LoginService proxy = (LoginService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.login("cuzz");
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        LoginService proxy = (LoginService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.login("cuzz");
    }


}