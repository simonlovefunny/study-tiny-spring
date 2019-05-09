package com.simon.factory;

import com.simon.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现基本的bean管理方法
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractBeanFactory.java,v0.1  2019/5/9 11:15 PM wuzhaoyi Exp$
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    /**
     * 创建bean方法
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
