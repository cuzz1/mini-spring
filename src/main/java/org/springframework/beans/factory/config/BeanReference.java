package org.springframework.beans.factory.config;

/**
 * 一个 bean 对另一个 bean 的引用
 * @author cuzz
 * @date 2022/2/14 20:15
 */
public class BeanReference {

    private final String beanName;

    public String getBeanName() {
        return beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
