package com.bdqn.mybatis.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @ClassName: ServiceLogger
 * @Description:定义包含增强方法的JavaBean(实现最终增强)
 * @Author: amielhs
 * @Date 2019-06-26
 */
@Aspect //使用注解定义切面
public class AfterLogger {
    private static final Logger log = Logger.getLogger(AfterLogger.class);

    //通过注解定义切点组件(业务层所有的方法)
    @Pointcut(value = "execution(* com.bdqn.mybatis.service..*.*(..))")
    public void pointCut(){}

    @After(value = "pointCut()")
    public void afterLogger(JoinPoint jp) {
        log.info(jp.getSignature().getName() + " 方法结束执行。");
    }
}
