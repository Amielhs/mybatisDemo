package com.bdqn.mybatis.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @ClassName: ServiceLogger
 * @Description:定义包含增强方法的JavaBean(日志增强类)
 * @Author: amielhs
 * @Date 2019-06-26
 */
@Aspect //使用注解定义切面
public class ServiceLogger {
    private static final Logger log = Logger.getLogger(ServiceLogger.class);

    //通过注解定义切点组件(业务层所有的方法)
    @Pointcut(value = "execution(* com.bdqn.mybatis.service..*.*(..))")
    public void pointCut(){}

    //代表前置增强的方法
    @Before(value = "pointCut()")
    public void before(JoinPoint jp){
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
    }

    //代表后置增强的方法
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
                + " 方法。方法返回值：" + result);
    }
}
