package com.my.spring.aop.impl2;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 把这个类声明为一个切面
 * 	  把这个类放入到IOC容器中，声明为一个切面
 */
@Order(2)	//@Order 注解来指定切面的优先级，值越小优先级越高
@Component
@Aspect
public class LoggingAspect
{
	/**
	 * 定义一个方法，用于声明切入点的表达式。一般的，该方法中不添加其他的代码。
	 * 使用@Pointcut来声明切入点表达式
	 * 后面的其他通知直接使用方法名称来引用当前的切入点表达式
	 */
	//@Pointcut("execution(public int com.my.spring.aop.impl2.ArithmeticCalculator.*(..))")
	@Pointcut("execution(* *.*(..))")
	public void declareJointPointExpression(){}
	
	/**
	 * 前置通知：
	 * 在com.my.spring.aop.impl2.ArithmeticCalculator接口的
	 * 每一实现类的每一个方法之前执行一段代码
	 */
	//@Before("execution(public int com.my.spring.aop.impl2.ArithmeticCalculator.*(..))")
	@Before("declareJointPointExpression()")
	public void beforeMethod1(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName +" begins with" + args);
	}
	
	/**
	 * 后置通知：
	 * 在目标方法执行后执行（无论是否发生异常）
	 */
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName +" ends with" + args);
	}
	
	/**
	 * 返回通知：
	 * 在方法正常执行后执行的代码，返回通知可以获取方法返回值
	 * @param joinPoint
	 */
	@AfterReturning(value="declareJointPointExpression()"
			, returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName +" return with:" + result);
	}
	
	/**
	 * 异常通知：
	 * 在目标方法出现异常时，才会执行的代码；
	 * 可以访问到异常对象，且可以在出现指定异常时再执行通知代码
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJointPointExpression()"
			, throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName +" throw with:" + ex);
		
	}
	
//	/**
//	 * 环绕通知：
//	 * 	需要携带ProceedingJoinPoint类型的参数，
//	 * 	环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
//	 *	且环绕通知必须有返回值，返回值即为目标方法的返回值；
//	 */
//	@Around("execution(public int com.my.spring.aop.impl2.ArithmeticCalculator.*(..))")
//	public Object roundMethod(ProceedingJoinPoint pdj)
//	{
//		Object result = null;
//		String methodName = pdj.getSignature().getName();
//		//执行目标方法
//		try
//		{
//			//前置通知
//			System.out.println("The method " + methodName +" begins with" + Arrays.asList(pdj.getArgs()));
//			
//			result = pdj.proceed();
//			
//			//返回通知
//			System.out.println("The method " + methodName +" return with" + Arrays.asList(pdj.getArgs()));
//			
//		}
//		catch (Throwable e)
//		{
//			//异常通知
//			System.out.println("The method " + methodName +" thorw with" + e);
//			throw new RuntimeException(e);
//		}
//		//后置通知
//		System.out.println("The method " + methodName +" ends");
//		
//		return result;
//	}
	
}
