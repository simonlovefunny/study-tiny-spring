package com.simon.factory;

import com.simon.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  抽象Bean工厂类
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractBeanFactory.java,v0.1  2019/5/26 9:30 AM wuzhaoyi Exp$
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionName = new ArrayList<>();


    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(null == beanDefinition){
            throw new IllegalArgumentException("No bean named "+name+" is defined");
        }
        Object bean = beanDefinition.getBean();
        if(null == bean){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionName.add(name);
        beanDefinitionMap.put(name,beanDefinition);
    }

    public void preInstanceSingletons() throws Exception{

        for(Iterator it = beanDefinitionName.iterator();it.hasNext();){
            String beanName = (String)it.next();
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;


}
