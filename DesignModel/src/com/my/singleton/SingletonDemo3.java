package com.my.singleton;

/**
 * 静态内部类式单例模式
 * 线程安全、调用效率高，并实现了延时加载
 */

public class SingletonDemo3
{
	//私有化构造器
	private SingletonDemo3(){}
	
	//静态内部类
	private static class SingletonClassInstance
	{
		private static final SingletonDemo3 instance = 
				new SingletonDemo3();
	}
	
	//调用效率高
	public static SingletonDemo3 getInstance()
	{
		return SingletonClassInstance.instance; 
	}
}
