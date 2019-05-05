package com.simon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Spring管理Bean的核心类
 * @Author: wuzhaoyi
 * @Date: 2019/5/5 11:05 PM
 * @Version: 1.0
 */
public class BeanFactory {

    Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name){ return beanDefinitionMap.get(name).getBean();}

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
