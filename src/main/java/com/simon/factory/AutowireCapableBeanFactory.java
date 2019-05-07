package com.simon.factory;

import com.simon.BeanDefinition;

/**
 * 可装配的Bean工厂，为注入属性做准备
 *
 * @Author: wuzhaoyi
 * @version: $id:AutowireCapableBeanFactory.java,v0.1  2019/5/7 9:51 PM wuzhaoyi Exp$
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {

        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return null;
    }
}
