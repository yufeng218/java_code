package com.my.spring.aop.impl2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class ValidationAspect
{
	//@Before("execution(public int com.my.spring.aop.impl2.ArithmeticCalculator.*(..))")
	@Before("com.my.spring.aop.impl2.LoggingAspect.declareJointPointExpression()")
	public void before(JoinPoint joinPoint)
	{
		System.out.println("validation -- begins :"+Arrays.asList(joinPoint.getArgs()));
	}
}
