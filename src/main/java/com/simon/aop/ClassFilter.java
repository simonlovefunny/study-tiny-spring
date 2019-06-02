package com.simon.aop;

/**
 *  aspectj的类适配器
 *
 * @Author: wuzhaoyi
 * @version: $id:ClassFilter.java,v0.1  2019/5/31 11:19 PM wuzhaoyi Exp$
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
