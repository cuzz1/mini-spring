package org.springframework.beans.factory;

/**
 * Bean 的属性
 * @author cuzz
 * @date 2022/2/13 21:58
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
