package com.simon.context;

import com.simon.HelloWorldService;
import org.junit.Test;

/**
 * 上下文容器测试
 *
 * @Author: wuzhaoyi
 * @version: $id:ApplicationContextTest.java,v0.1  2019/5/27 10:19 PM wuzhaoyi Exp$
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studyTiny.xml");

        HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");

        helloWorldService.helloWorld();
    }
}
