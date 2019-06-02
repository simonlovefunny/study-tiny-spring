package com.simon.aop;

import com.simon.HelloWorldService;
import org.junit.Assert;
import org.junit.Test;

/**
 * aop切面测试类
 *
 * @Author: wuzhaoyi
 * @version: $id:AspectHExpressionPointcutTest.java,v0.1  2019/6/2 3:31 PM wuzhaoyi Exp$
 */
public class AspectHExpressionPointcutTest {


    @Test
    public void testClassFilter() throws Exception{
        String expression = "execution(* com.simon.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }


    @Test
    public void testMethodInterceptor() throws Exception{
        String expression = "execution(* com.simon.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldService.class.getDeclaredMethod("helloWorld"),HelloWorldService.class);
        Assert.assertTrue(matches);

    }
}
