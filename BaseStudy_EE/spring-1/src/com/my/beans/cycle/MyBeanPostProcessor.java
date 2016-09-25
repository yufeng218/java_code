package com.my.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException
	{
		System.out.println("postProcessAfterInitialization:" + bean + "," + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException
	{
		System.out.println("postProcessBeforeInitialization:" + bean + "," + beanName);
		Car car = new Car();
		car.setBrand("Ford");
		return car;
	}

}
