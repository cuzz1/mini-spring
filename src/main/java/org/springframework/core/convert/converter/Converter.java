package org.springframework.core.convert.converter;

/**
 * 类型转换
 *
 * @author cuzz
 * @date 2022/3/1 14:34
 */
public interface Converter<S, T> {
    /**
     * 类型转换
     */
    T convert(S source);
}
