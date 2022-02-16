package org.springframework.beans.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cuzz
 * @date 2022/2/13 21:59
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public void addPropertyValues(PropertyValue... propertyValues) {
        propertyValueList.addAll(Arrays.stream(propertyValues).collect(Collectors.toList()));
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


    public PropertyValue getPropertyValue(String propertyName) {
        return propertyValueList.stream()
                .filter(property -> Objects.equals(property.getName(), propertyName))
                .findFirst()
                .orElse(null);
    }

}
