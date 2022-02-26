package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author cuzz
 * @date 2022/2/26 22:28
 */
public class PackageScanTest {

    @Test
    public void testScanPackage() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");

        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);
        assertThat(book).isNotNull();
    }
}
