package com.simon.aop;

/**
 * 被代理的对象
 *
 * @Author: wuzhaoyi
 * @version: $id:TargetSource.java,v0.1  2019/5/28 11:14 AM wuzhaoyi Exp$
 */
public class TargetSource {

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    private Object target;

    public TargetSource(Object target,Class<?> targetClass, Class<?>... interfaces) {
        this.targetClass = targetClass;
        this.interfaces = interfaces;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public Object getTarget() {
        return target;
    }
}
