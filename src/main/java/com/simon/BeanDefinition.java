package com.simon;

/**
 * @Description: Spring定义Bean的核心类
 * @Author: wuzhaoyi
 * @Date: 2019/5/5 10:36 PM
 * @Version: 1.0
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }

}
