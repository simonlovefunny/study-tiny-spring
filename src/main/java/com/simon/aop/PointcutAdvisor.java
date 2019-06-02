package com.simon.aop;

/**
 * PointCut的通知类
 *
 * @Author: wuzhaoyi
 * @version: $id:PointcutAdvisor.java,v0.1  2019/5/31 11:36 PM wuzhaoyi Exp$
 */
public interface PointcutAdvisor {

    PointCut getPointCut();
}
