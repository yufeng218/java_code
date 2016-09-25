package com.my.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 把这个类声明为一个切面
 * 	  把这个类放入到IOC容器中，声明为一个切面
 */
@Component
@Aspect
public class LoggingAspect
{
	//声明该方法是一个前置通知：在目标方法开始之前执行
	//@Before("execution(public int com.my.spring.aop.impl.ArithmeticCalculatorImpl.add(int, int))")
	@Before("execution(public int com.my.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method" + methodName +" begins with" + args);
	}
	
	//后置通知：在目标方法执行之后执行(无论方法是否出现异常)
	//在后置通知中还不能访问目标方法执行的结果，需要在返回通知中访问。
	@After("execution(* com.my.spring.aop.impl.ArithmeticCalculatorImpl.*(int, int))")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method" + methodName +" ends with" + args);
	
	}
}
