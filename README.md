
# mini-spring

## 实现 AnnotationConfigApplicationContext

实现 AnnotationConfigApplicationContext 注解容器，解析@Configuration配置
```java

public class ConfigurationTest {
    
    @Test
    public void testAnnotationConfig() throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = applicationContext.getBean(AppConfig.class);

        System.out.println(appConfig);
        A a = applicationContext.getBean(A.class);
        System.out.println(a);
    }

}
    
```

打印结果：
```
org.springframework.test.configuration.AppConfig@69a3d1d
org.springframework.test.configuration.A@86be70a
```

## 参考 
- https://github.com/DerekYRC/mini-spring 
