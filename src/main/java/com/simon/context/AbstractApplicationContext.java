package com.simon.context;

import com.simon.beans.BeanDefinition;
import com.simon.beans.BeanPostProcessor;
import com.simon.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * 抽象的应用上下文
 *
 * @Author: wuzhaoyi
 * @version: $id:AbstractApplicationContext.java,v0.1  2019/5/27 10:06 PM wuzhaoyi Exp$
 */
public abstract class  AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory abstractBeanFactory) {
        this.beanFactory = abstractBeanFactory;
    }

    public void refresh() throws Exception{
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }


}
