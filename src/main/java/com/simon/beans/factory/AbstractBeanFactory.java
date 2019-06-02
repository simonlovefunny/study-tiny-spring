package com.simon.beans.factory;

import com.simon.beans.BeanDefinition;
import com.simon.beans.BeanPostProcessor;

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

    private final List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(null == beanDefinition){
            throw new IllegalArgumentException("No bean named "+name+" is defined");
        }
        Object bean = beanDefinition.getBean();
        if(null == bean){
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean,name);
        }
        return bean;
    }


    protected Object initializeBean(Object bean,String name) throws Exception{
        for(BeanPostProcessor beanPostProcessor : beanPostProcessors){
            bean = beanPostProcessor.postProcessBeforeInitialization(bean,name);
        }

        //TODO call initialize method

        for(BeanPostProcessor beanPostProcessor : beanPostProcessors){
            bean = beanPostProcessor.postProcessAfterInitialization(bean,name);
        }

        return bean;
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionNames.add(name);
        beanDefinitionMap.put(name,beanDefinition);
    }

    public void preInstantiateSingletons() throws Exception{

        for(Iterator it = beanDefinitionNames.iterator();it.hasNext();){
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


    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception{
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<Object>();
        for(String beanDefinitionName : beanDefinitionNames){
            if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())){
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

}
