package org.springframework.test.ioc.bean;

/**
 * @author cuzz
 * @date 2022/2/14 20:30
 */
public class Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
