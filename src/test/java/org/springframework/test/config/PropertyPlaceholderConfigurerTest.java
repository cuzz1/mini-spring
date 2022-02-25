package org.springframework.test.config;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Book;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PropertyPlaceholderConfigurerTest {

	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

		Book book = applicationContext.getBean("book", Book.class);
		System.out.println(book);
		assertThat(book.getTitle()).isEqualTo("Python Cookbook");
	}
}