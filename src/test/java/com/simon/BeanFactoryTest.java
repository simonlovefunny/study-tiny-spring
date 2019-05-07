package com.simon;

import com.simon.factory.AutowireCapableBeanFactory;
import com.simon.factory.BeanFactory;
import org.junit.Test;

/**
 * Bean工厂测试
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactoryTest.java,v0.1  2019/5/7 10:01 PM wuzhaoyi Exp$
 */
public class BeanFactoryTest {

    @Test
    public void init(){

        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.simon.HelloWorldService");

        //将bean注册到工厂
        beanFactory.registerBeanDefinition("helloService",beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloService");
        helloWorldService.sayHello();
    }

}
