package org.springframework.beans.factory;

/**
 * 实现该接口，能感知所属的BeanFactory
 *
 * @author cuzz
 * @date 2022/2/18 22:12
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
