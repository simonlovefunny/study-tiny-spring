package com.simon;

import com.simon.factory.AutowireCapableBeanFactory;
import com.simon.factory.BeanFactory;
import org.junit.Test;

/**
 * todo
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactoryTest.java,v0.1  2019/5/9 11:25 PM wuzhaoyi Exp$
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.simon.HelloWorldService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addProperty(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
