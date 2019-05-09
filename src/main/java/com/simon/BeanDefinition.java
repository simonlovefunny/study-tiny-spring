package com.simon;

/**
 * bean的定义，类型以及属性值
 *
 * @Author: wuzhaoyi
 * @version: $id:BeanDefinition.java,v0.1  2019/5/9 10:07 PM wuzhaoyi Exp$
 */
public class BeanDefinition {


    private Object bean;

    private String beanClassName;

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try{
            this.beanClass = Class.forName(beanClassName);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "bean=" + bean +
                ", beanClassName='" + beanClassName + '\'' +
                ", beanClass=" + beanClass +
                ", propertyValues=" + propertyValues +
                '}';
    }
}
