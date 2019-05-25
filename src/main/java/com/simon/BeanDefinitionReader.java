package com.simon;

/**
 * 定义从资源中读取BeanDefition的接口
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanDefinitionReader.java,v0.1  2019/5/25 8:36 PM wuzhaoyi Exp$
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
