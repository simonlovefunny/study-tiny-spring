package com.simon.aop;

/**
 * 被代理的对象
 *
 * @Author: wuzhaoyi
 * @version: $id:TargetSource.java,v0.1  2019/5/28 11:14 AM wuzhaoyi Exp$
 */
public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource(Class<?> targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
