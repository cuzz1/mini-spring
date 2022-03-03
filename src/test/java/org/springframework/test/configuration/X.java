package org.springframework.test.configuration;

public class X {

	public X() {
		System.out.println("X....");
	}

	public void func(String message) {
		System.out.println("X func message: " + message);
	}
}