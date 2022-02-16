package org.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author cuzz
 * @date 2022/2/14 21:00
 */
public class DefaultResourceLoader implements ResourceLoader {
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {

        if (location == null) {
            throw new IllegalArgumentException("location cannot be null.");
        }

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // 尝试当做 url 处理
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
