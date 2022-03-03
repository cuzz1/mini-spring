package org.springframework.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cuzz
 * @date 2022/3/3 15:41
 */
@Configuration // 用来保证 bean 的作用域
public class AppConfig {

    @Bean
    public Y y() {
        return new Y();
    }

    @Bean
    public X x() {
        y();
        return new X();
    }


}