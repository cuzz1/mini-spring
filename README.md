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
/**
 * @author cuzz
 * @date 2022/3/16 22:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Person person;

    @Override
    public String getUseName() {
        return person.getName();
    }
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
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println(bean);

        applicationContext.close();
    }
}

```

打印结果：

```
Car customInitMethod...
beanName: myCar bean: Car{name='BMW', color='red'}
org.springframework.test.configuration.UserServiceImpl@3439f68d
Car customDestroyMethod...
```

## 参考

- https://github.com/DerekYRC/mini-spring 
