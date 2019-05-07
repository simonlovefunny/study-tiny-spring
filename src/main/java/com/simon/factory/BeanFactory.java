package com.simon.factory;

import com.simon.BeanDefinition;

/**2
 * Bean工厂接口化，为后续多种类型的Bean工厂定义功能
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactory.java,v0.1  2019/5/7 9:36 PM wuzhaoyi Exp$
 */
public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
