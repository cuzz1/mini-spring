package org.springframework.test.configuration;

import org.springframework.beans.factory.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * @author cuzz
 * @date 2022/3/3 15:41
 */
@Configuration
@PropertySource("classpath:person.properties")
@ComponentScan(basePackages = {"org.springframework.test.configuration"})
public class AppConfig {

    @Bean(name = "aa")
    @Scope("prototype")
    public A a() {
        return new A();
    }

    @Bean(name = "myCar", initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public Car car() {
        return new Car("BMW", "red");
    }
}