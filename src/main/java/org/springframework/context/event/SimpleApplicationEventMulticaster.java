package org.springframework.context.event;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author cuzz
 * @date 2022/2/19 14:46
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {

        for (ApplicationListener<ApplicationEvent> applicationListener : super.applicationListeners) {
            if (supportsEvent(applicationListener, event)) {
                applicationListener.onApplicationEvent(event);
            }
        }
    }

    /**
     * 监听是否对该事件感兴趣
     *
     * @param applicationListener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        // 获取泛型接口列表
        Type[] types = applicationListener.getClass().getGenericInterfaces();
        // 只有一个接口，取第一个
        Type type = types[0];
        // 获取泛型的实际类型列表
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        // 只有一个泛型，取第一个
        Type actualTypeArgument = actualTypeArguments[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 父类.class.isAssignableFrom(子类.class)
        return eventClassName.isAssignableFrom(event.getClass());

    }
}
