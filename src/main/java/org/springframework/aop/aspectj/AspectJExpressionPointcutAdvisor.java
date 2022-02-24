package org.springframework.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * 实现了 PointcutAdvisor 接口，
 * 把切面 pointcut、拦截方法 advice 和具体的拦截表达式包装在一起。
 * <p>
 * Spring AOP Advisor that can be used for any AspectJ pointcut expression.
 *
 * @author cuzz
 * @date 2022/2/24 21:40
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;


    /**
     * 具体拦截的方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    public AspectJExpressionPointcutAdvisor() {
        // System.out.println("AspectJExpressionPointcutAdvisor constructor");
    }


    public void setExpression(String expression) {
        this.expression = expression;
    }


    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
