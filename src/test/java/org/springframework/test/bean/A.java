package org.springframework.test.bean;

/**
 * @author cuzz
 * @date 2022/3/1 11:05
 */
public class A {

    private B b;

    public void func(){}

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}