package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和访问接口
 *
 * @author cuzz
 * @date 2022/2/14 20:43
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
