package com.simon.aop;

/**
 * Spring的切入点
 *
 * @Author: wuzhaoyi
 * @version: $id:PointCut.java,v0.1  2019/5/31 11:24 PM wuzhaoyi Exp$
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
