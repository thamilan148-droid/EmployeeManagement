package com.employee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Before("execution(* com.employee.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Operation started: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.employee.service.*.*(..))",
            returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("Operation completed: {}", joinPoint.getSignature().getName());
    }
}
