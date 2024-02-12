package com.fyodork.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.fyodork.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable
    {
        MethodSignature methodSignature= (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName= methodSignature.getName();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Begin of method :"+dtf.format(now)+" "+methodName);
        Object targetMethodResult=proceedingJoinPoint.proceed();

        System.out.println("end of method:"+dtf.format(now)+" "+methodName);
        return targetMethodResult;
    }
}
