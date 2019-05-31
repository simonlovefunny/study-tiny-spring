package com.simon.aop;

import com.simon.HelloWorldService;
import com.simon.context.ApplicationContext;
import com.simon.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * 测试jdk动态代理容器
 *
 * @Author: wuzhaoyi
 * @version: $id:JdkDynamicAopProxyTest.java,v0.1  2019/5/31 7:29 PM wuzhaoyi Exp$
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void test() throws Exception{

        //init context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studyTiny.xml");

        //helloWorldService without aop
        HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();;

        //helloWorldService with aop
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloWorldService.class,helloWorldService);
        advisedSupport.setTargetSource(targetSource);

        //set interceptor
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        //set proxy
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldProxy = (HelloWorldService)jdkDynamicAopProxy.getProxy();

        helloWorldProxy.helloWorld();
    }
}
