package com.simon.factory;

import com.simon.BeanDefinition;
import com.simon.PropertyValue;
import com.simon.PropertyValues;

import java.lang.reflect.Field;

/**
 * 实际的Bean工厂类
 *
 * @Author: wuzhaoyi
 * @version: $id:AutowireCapableBeanFactory.java,v0.1  2019/5/9 11:19 PM wuzhaoyi Exp$
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception{
        for(PropertyValue pv:beanDefinition.getPropertyValues().getPropertyValueList()){
            Field declaredField = bean.getClass().getDeclaredField(pv.getKey());
            //使用反射绕过private限制为字段直接赋值
            declaredField.setAccessible(true);
            declaredField.set(bean,pv.getValue());

        }
    }
}
