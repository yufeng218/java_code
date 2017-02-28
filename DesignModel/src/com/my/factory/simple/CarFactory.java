package com.my.factory.simple;

/**
 * 
 * 简单工厂的实现
 *
 */
public class CarFactory
{
	//实现方式1
//	public static Car createCar(String type)
//	{
//		if("奥迪".equals(type))
//		{
//			return new Audi();
//		}
//		else if("比亚迪".equals(type))
//		{
//			return new Byd();
//		}
//		else
//		{
//			return null;
//		}
//	}
	
	//实现方式2
	public static Car createAudi()
	{
		return new Audi();
	}
	
	public static Car createByd()
	{
		return new Byd();
	}
	
}
