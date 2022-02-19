package org.springframework.test.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author cuzz
 * @date 2022/2/19 13:21
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    private String name;
    private Integer age;

    public PersonFactoryBean() {
    }

    public PersonFactoryBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public Person getObject() throws Exception {
        return new Person("My name is " + this.name, this.age);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
