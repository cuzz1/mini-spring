package org.springframework.test.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.service.LoginService;

public class AutoProxyTest {

	@Test
	public void testAutoProxy() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

		// 获取代理对象
		LoginService loginService = applicationContext.getBean("loginService", LoginService.class);
		System.out.println(loginService.getMsg());
		loginService.login("cuzz");
	}
}