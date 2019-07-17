package com.bdqn.mybatis.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @ClassName: ServiceLogger
 * @Description:定义包含增强方法的JavaBean(实现异常抛出增强)
 * @Author: amielhs
 * @Date 2019-06-26
 */
@Aspect //使用注解定义切面
public class ErrorLogger {
    private static final Logger log = Logger.getLogger(ErrorLogger.class);

    //通过注解定义切点组件(业务层所有的方法)
    @Pointcut(value = "execution(* com.bdqn.mybatis.service..*.*(..))")
    public void pointCut(){}

    //抛出异常方法
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowing(JoinPoint jp,RuntimeException e){
        log.error(jp.getSignature().getName()+"方法发生异常："+e);
    }
}
