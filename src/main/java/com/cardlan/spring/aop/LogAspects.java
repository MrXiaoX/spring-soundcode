package com.cardlan.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 告诉spring这是一个切面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他切面引用
    @Pointcut("execution(public int com.cardlan.spring.aop.MathCalculator.div(int ,int ))")
    public void pointcut()
    {
    }

    // @Before 在目标方法之前切入: 切入点表达式(指定在哪个方法切入)
    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(String.format("%s除法运行  参数列表{%s}",joinPoint.getSignature().getName(),Arrays.asList(args)));
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(String.format("%s除法结束》》",joinPoint.getSignature().getName()));
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(String.format("%s除法造成返回 运行结果{%s}",joinPoint.getSignature().getName(),result));
    }

    //JoinPoint joinPoin 必须要第一位参数
    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(String.format("%s除法造成异常 异常信息{%s}",joinPoint.getSignature().getName(),exception));
    }
}
