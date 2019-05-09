package com.simon.factory;

import com.simon.BeanDefinition;

/**
 * Bean工厂接口化，支持后续的拓展
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactory.java,v0.1  2019/5/9 11:14 PM wuzhaoyi Exp$
 */
public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;
}
