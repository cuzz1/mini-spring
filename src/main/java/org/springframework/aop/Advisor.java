package org.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 定义Advisor访问者
 *
 * @author cuzz
 * @date 2022/2/24 21:33
 */
public interface Advisor {
    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     *
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
