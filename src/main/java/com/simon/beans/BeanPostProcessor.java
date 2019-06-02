package com.simon.beans;

/**
 * 定义在spring初始化bean的时候使用aop的接口
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanPostProcessor.java,v0.1  2019/6/2 3:51 PM wuzhaoyi Exp$
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean,String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean,String beanName) throws Exception;
}
