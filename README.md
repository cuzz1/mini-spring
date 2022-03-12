# mini-spring

## 实现 AnnotationConfigApplicationContext

实现 AnnotationConfigApplicationContext 注解容器，解析@Configuration配置，实现包扫描

配置

```java

@ComponentScan(basePackages = {"org.springframework.test.configuration"})
@Configuration
public class AppConfig {

    @Bean
    public A a() {
        return new A();
    }
}
```

```java

public class ConfigurationTest {

    @Test
    public void testAnnotationConfig() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = applicationContext.getBean(AppConfig.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }
}

```

打印结果：

```
a
appConfig
person
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
```

## 参考

- https://github.com/DerekYRC/mini-spring 
