package com.simon.factory;


import com.simon.BeanDefinition;

/**
 * Bean工厂接口
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
