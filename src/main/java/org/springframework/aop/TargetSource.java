package org.springframework.aop;

/**
 * 被代理的目标对象
 *
 * @author cuzz
 * @date 2022/2/21 22:44
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
