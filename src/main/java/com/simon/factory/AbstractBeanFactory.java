package com.simon.factory;

import com.simon.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象Bean工厂类，实现基本的bean管理方法
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractBeanFactory.java,v0.1  2019/5/7 9:40 PM wuzhaoyi Exp$
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
      Object bean = doCreateBean(beanDefinition);
      beanDefinition.setBean(bean);
      beanDefinitionMap.put(beanName,beanDefinition);
    }

    /**
     * 创建Bean实例
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}
