package com.simon.aop;

import org.aopalliance.aop.Advice;

/**
 * 通知
 *
 * @Author: wuzhaoyi
 * @version: $id:Advisor.java,v0.1  2019/5/31 11:35 PM wuzhaoyi Exp$
 */
public interface Advisor {

    Advice getAdvice();
}
