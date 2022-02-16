package org.springframework.beans.factory;

/**
 * @author cuzz
 * @date 2022/2/13 14:02
 */
public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
