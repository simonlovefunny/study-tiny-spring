package com.simon.aop;

import com.simon.beans.factory.BeanFactory;

/**
 * bean工厂管理接口
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanFactoryAware.java,v0.1  2019/6/2 3:54 PM wuzhaoyi Exp$
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory)throws Exception;
}
