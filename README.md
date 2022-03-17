# mini-spring

## 实现 AnnotationConfigApplicationContext

实现 AnnotationConfigApplicationContext 注解容器，实现以下功能：

- 解析配置@Configuration注解
- 实现包扫描@ComponentScan注解
- 解析方法上上@Bean注解
- 解析配置文件@PropertySource注册

```java
@Configuration
@PropertySource("classpath:person.properties")
@ComponentScan(basePackages = {"org.springframework.test.configuration"})
public class AppConfig {

    @Bean(name = "aa")
    public A a() {
        return new A();
    }

    @Bean(name = "myCar", initMethod = "initMethod", destroyMethod = "destroyMethod")
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
        Map<String, Car> beansMap = applicationContext.getBeansOfType(Car.class);
        for (Map.Entry<String, Car> stringCarEntry : beansMap.entrySet()) {
            System.out.println("beanName: " + stringCarEntry.getKey() + " bean: " + stringCarEntry.getValue());
        }
        applicationContext.close();


    }
}

```

打印结果：

```
Car customInitMethod...
beanName: myCar bean: Car{name='BMW', color='red'}
Car customDestroyMethod...
```

## 参考

- https://github.com/DerekYRC/mini-spring 
