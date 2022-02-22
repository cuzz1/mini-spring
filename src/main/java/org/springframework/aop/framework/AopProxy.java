package org.springframework.aop.framework;

/**
 * @author cuzz
 * @date 2022/2/21 22:48
 */
public interface AopProxy {

    /**
     * Create a new proxy object.
     * <p>Uses the AopProxy's default class loader (if necessary for proxy creation):
     * usually, the thread context class loader.
     * @return the new proxy object (never {@code null})
     * @see Thread#getContextClassLoader()
     */
    Object getProxy();
}
