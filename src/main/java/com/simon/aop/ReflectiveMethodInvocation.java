package com.simon.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 反射实现的切入点
 *
 * @Author: wuzhaoyi
 * @version: $id:ReflectiveMethodInvocation.java,v0.1  2019/5/28 11:30 AM wuzhaoyi Exp$
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    /** 被代理类 */
    private Object target;

    /** 被代理的方法 */
    private Method method;

    /** 方法入参数?如何获取 */
    private Object[] args;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    /**
     * 调用被代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target,args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    /**
     * 获取被调用方法
     * @return
     */
    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
