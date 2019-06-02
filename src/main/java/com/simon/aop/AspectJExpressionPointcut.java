package com.simon.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * @Author: wuzhaoyi
 * @version: $id:AspectJExpressionPointcut.java,v0.1  2019/5/31 11:39 PM wuzhaoyi Exp$
 */
public class AspectJExpressionPointcut implements PointCut,ClassFilter, MethodMatcher {

    /** 切入点解析器 */
    private PointcutParser pointcutParser;

    /** 切入表达式 */
    private String expression;

    /** 切入点 */
    private PointcutExpression pointcutExpression;

    /** 切入点集合 */
    private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES = new HashSet<>();


    static{
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
        DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
    }

    public AspectJExpressionPointcut() {
        this(DEFAULT_SUPPORTED_PRIMITIVES);
    }

    public AspectJExpressionPointcut(Set<PointcutPrimitive> supportedPrimitives) {
        pointcutParser = PointcutParser
                .getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(supportedPrimitives);
    }


    protected void checkReadyToMatch(){
        if(pointcutExpression == null){
            pointcutExpression = buildPointExpression();
        }
    }

    private PointcutExpression buildPointExpression(){
       return pointcutParser.parsePointcutExpression(expression);
    }

    public void setExpression(String expression){
        this.expression = expression;
    }
    @Override
    public boolean matches(Class targetClass) {
        checkReadyToMatch();
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }


    @Override
    public boolean matches(Method method, Class targetClass) {

        checkReadyToMatch();

        ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);

        if(shadowMatch.alwaysMatches()){
            return true;
        }

        return false;
    }
}
