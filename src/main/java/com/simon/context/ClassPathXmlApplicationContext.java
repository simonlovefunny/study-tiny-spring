package com.simon.context;

import com.simon.beans.BeanDefinition;
import com.simon.beans.factory.AbstractBeanFactory;
import com.simon.beans.factory.AutowireCapableBeanFactory;
import com.simon.beans.io.ResourceLoader;
import com.simon.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 类路径的上下文容器类
 *
 * @Author: wuzhaoyi
 * @version: $id:ClassPathXmlApplicationContext.java,v0.1  2019/5/27 10:14 PM wuzhaoyi Exp$
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory abstractBeanFactory) throws Exception{
        super(abstractBeanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
