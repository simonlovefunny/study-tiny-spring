package com.simon.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 时间拦截器
 *
 * @Author: wuzhaoyi
 * @version: $id:TimerInterceptor.java,v0.1  2019/5/31 7:23 PM wuzhaoyi Exp$
 */
public class TimerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        long time = System.nanoTime();

        System.out.println("Invocation of Method "+invocation.getMethod().getName()+" start!");

        Object proceed = invocation.proceed();

        System.out.println("Invocation of Method "+invocation.getMethod().getName()+" ends! takes "+(System.nanoTime() - time ));

        return proceed;
    }
}
