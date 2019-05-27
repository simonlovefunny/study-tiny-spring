package com.simon;

import com.simon.factory.AbstractBeanFactory;
import com.simon.factory.AutowireCapableBeanFactory;
import com.simon.io.ResourceLoader;
import com.simon.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Bean工厂测试
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactoryTest.java,v0.1  2019/5/27 9:21 PM wuzhaoyi Exp$
 */
public class BeanFactoryTest {

    @Test
    public void testLazy() throws Exception {

        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("studyTiny.xml");

        //2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry: xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }

    @Test
    public void testPreInstance()throws Exception{
        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("studyTiny.xml");

        //2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry: xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.初始化bean
        beanFactory.preInstanceSingletons();

        //4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
