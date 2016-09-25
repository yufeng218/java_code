package com.my.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


public class ValidationAspect
{
	public void before(JoinPoint joinPoint)
	{
		System.out.println("validation -- begins :"+Arrays.asList(joinPoint.getArgs()));
	}
}
