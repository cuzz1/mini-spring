package org.springframework.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuzz
 * @date 2022/3/3 15:41
 */
@Configuration
public class AppConfig {

    @Bean
    public A a() {
        return new A();
    }




}