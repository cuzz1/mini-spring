package org.springframework.test.configuration;

/**
 * @author cuzz
 * @date 2022/3/13 22:29
 */
public class Car {
    private String name;
    private String color;


    public Car() {
    }


    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
