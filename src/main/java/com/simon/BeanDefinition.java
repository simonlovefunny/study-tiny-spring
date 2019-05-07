package com.simon;

/**
 * BeamDefinition第二版，相比较第一部的BeanDefinition包含更多的类信息
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanDefinition.java,v0.1  2019/5/7 9:32 PM wuzhaoyi Exp$
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try{
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
