tiny-spring学习项目
======


>A study project of tiny-spring

## 关于

[tiny-spring](https://github.com/code4craft/tiny-spring)项目是一个对于Spring框架的核心功能实现，作为一名
Java语言使用者，Spring框架是必须深刻理解的，因此有了这个项目。按照tiny-spring作者的说法，这是对于已完成项目的临摹。


AOP
Spring Aop仅支持方法级别的调用
MethodInterceptor-Advice 切点指定的逻辑
MethodInvocation-Joinpoint 切入点

Spring的JoinPoint包含两个角色：ClassFilter和MethodMatcher,分别对类和方法做适配

advice 通知是切面的一种实现，可以完成简单的织入功能。通知定义了增强代码切入目标代码的时间点。

advisor 顾问是切面的另一种实现，可以将通知以更为复杂的方式织入到目标对象，是将通知包装为更复杂切面的适配器


AOP融入Spring创建bean的过程

BeanPostProcessor BeanFactory提供了BeanPostProcessor，如果bean实现了BeanPostProcessor接口，那么spring在初始化bean的过程中就会优先找到它们，并在bean初始化的时候，调用这个接口方法。


cglib实现代理








