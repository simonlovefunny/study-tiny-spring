package com.simon.aop;

import org.aopalliance.aop.Advice;

/**
 * AOP切点通知（增强)类
 *
 * @Author: wuzhaoyi
 * @version: $id:AspectJExpressionPointcutAdvisor.java,v0.1  2019/6/2 3:57 PM wuzhaoyi Exp$
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor{

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression){
        this.pointcut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointCut() {
        return pointcut;
    }
}
