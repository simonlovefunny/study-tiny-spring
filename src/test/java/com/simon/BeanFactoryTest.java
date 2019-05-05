package com.simon;

import org.junit.Test;

/**
 * @Description: BeanFactory测试
 * @Author: wuzhaoyi
 * @Date: 2019/5/5 11:10 PM
 * @Version: 1.0
 */
public class BeanFactoryTest {

    @Test
    public void init(){

        //1.初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2.注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);

        //3.获取Bean实例
        HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService.hello();

    }
}
