package com.simon.beans;

/**
 * 引用Bean定义
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanReference.java,v0.1  2019/5/26 9:54 AM wuzhaoyi Exp$
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
