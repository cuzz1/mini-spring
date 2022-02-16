package org.springframework.test.ioc.service;

public class HelloService {

	public String sayHello() {
		System.out.println("hello");
		return "hello";
	}
}