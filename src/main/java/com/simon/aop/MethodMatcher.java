package com.simon.aop;

import java.lang.reflect.Method;

/**
 * aspectj方法适配器
 *
 * @Author: wuzhaoyi
 * @version: $id:MethodMatcher.java,v0.1  2019/5/31 11:20 PM wuzhaoyi Exp$
 */
public interface MethodMatcher {

    boolean matches(Method method,Class targetClass);
}
