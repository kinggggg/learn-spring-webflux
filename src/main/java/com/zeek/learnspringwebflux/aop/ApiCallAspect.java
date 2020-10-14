package com.zeek.learnspringwebflux.aop;

import com.zeek.learnspringwebflux.exception.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApiCallAspect
 * @Description
 * @Author liweibo
 * @Date 2020/10/14 11:37 下午
 * @Version v1.0
 **/
@Aspect
@Component
public class ApiCallAspect {

//    @Pointcut("@annotation(com.zeek.learnspringwebflux.annotation.ApiCallMonitor)")
    @Pointcut("execution(public * com.zeek.learnspringwebflux.service.*.*(..))")
    public void apiCallMonitor() {

    }

    @Around("apiCallMonitor()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) {

        try {
            System.out.println("service方法执行前");

            Object proceed = proceedingJoinPoint.proceed();
            System.out.println(proceed);

            System.out.println("service方法执行后");
        } catch (Throwable throwable) {
            System.out.println("error: 系统错误");
            throw new BusinessException(500, "系统错误");
        }

    }

}
