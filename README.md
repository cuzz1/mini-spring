# mini-spring

## 实现 AnnotationConfigApplicationContext

实现 AnnotationConfigApplicationContext 注解容器，实现以下功能：

- 解析配置@Configuration注解
- 实现包扫描@ComponentScan注解
- 解析方法上上@Bean注解
- 解析配置文件@PropertySource注册

```java

@Configuration
@ComponentScan(basePackages = {"org.springframework.test.configuration"})
@PropertySource("classpath:person.properties")
public class AppConfig {

    @Bean
    public A a() {
        return new A();
    }


    @Bean
    public Car car() {
        return new Car("BMW", "red");
    }
}
```


```java

@Component
public class Person {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    // getter and setter...
}
```

```java

public class ConfigurationTest {

    @Test
    public void testAnnotationConfig() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("name: " + beanName);
            System.out.println("bean: " + applicationContext.getBean(beanName));
            System.out.println("--------------------");
        }
    }

}

```

打印结果：

```
name: PropertyPlaceholderConfigurer
bean: org.springframework.beans.factory.PropertyPlaceholderConfigurer@4b9e255
--------------------
name: aa
bean: org.springframework.test.configuration.A@5e57643e
--------------------
name: myCar
bean: Car{name='BMW', color='red'}
--------------------
name: appConfig
bean: org.springframework.test.configuration.AppConfig@133e16fd
--------------------
name: person
bean: Person{name='cuzz', age=18}
--------------------
name: org.springframework.context.annotation.internalConfigurationAnnotationProcessor
bean: org.springframework.context.annotation.ConfigurationClassPostProcessor@51b279c9
--------------------
name: org.springframework.context.annotation.internalAutowiredAnnotationProcessor
bean: org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@1ad282e0
-------------------


```

## 参考

- https://github.com/DerekYRC/mini-spring 
