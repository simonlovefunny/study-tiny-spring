package com.simon;

import com.simon.beans.BeanPostProcessor;

/**
 * todo
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanInitializeLogger.java,v0.1  2019/6/2 4:21 PM wuzhaoyi Exp$
 */
public class BeanInitializeLogger implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println("Initialize bean "+beanName +" end!");
        return bean;
    }
}
