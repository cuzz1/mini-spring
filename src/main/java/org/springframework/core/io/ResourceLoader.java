package org.springframework.core.io;

/**
 * 资源加载器接口
 *
 * @author cuzz
 * @date 2022/2/14 20:59
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
