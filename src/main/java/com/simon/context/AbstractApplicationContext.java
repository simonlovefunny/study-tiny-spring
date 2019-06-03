package com.simon.context;

import com.simon.beans.BeanDefinition;
import com.simon.beans.factory.AbstractBeanFactory;

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

    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

}
