package org.springframework.aop.framework;

import org.springframework.aop.AdvisedSupport;

/**
 * @author cuzz
 * @date 2022/2/24 21:49
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;
    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new CglibAopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }

}
