package com.training.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class CommonLogging {

	@Pointcut("execution(* com.training.service.*.*(..))")
	public void getLogsForAllMethods(){
		
	}
	
	@Before("getLogsForAllMethods()")
	public void beforeAdviceForTransferMethods(JoinPoint joinPoint){
		System.out.println("***LogginingAspect.BeforeAdviceForTransferMethod() "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.training.service.*.*(..))")
	public void afterAdviceForTransferMethods(JoinPoint joinPoint){
		System.out.println("***LogginingAspect.AfterAdviceForTransferMethod() "+joinPoint.getSignature().getName());
	}
	
	@Around("execution(* com.training.service.*.*(..))")
	public void longAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("longAround is running");
		System.out.println("method hijacked "+joinPoint.getSignature().getName());
		System.out.println("hijacked arguments "+Arrays.toString(joinPoint.getArgs()));
		System.out.println("Around before is running");
		joinPoint.proceed();
		System.out.println("around after is running");
		System.out.println("***********");
	}
	
	
}
