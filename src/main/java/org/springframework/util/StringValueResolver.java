package org.springframework.util;

/**
 * 定义解析字符串接口
 *
 * @author cuzz
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);
}
