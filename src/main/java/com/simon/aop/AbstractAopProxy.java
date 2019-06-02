package com.simon.aop;

/**
 * 抽象aop代理管理类
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractAopProxy.java,v0.1  2019/6/2 5:50 PM wuzhaoyi Exp$
 */
public abstract class AbstractAopProxy implements AopProxy{

    protected AdvisedSupport advisedSupport;

    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
