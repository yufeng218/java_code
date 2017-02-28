package com.my.singleton;

/**
 * 懒汉式单例模式
 *
 */

public class SingletonDemo2
{
	//私有化构造器
	private SingletonDemo2(){}
	
	//类初始化时，不初始化这个对象(延时加载)，真正使用的时候再加载
	private static SingletonDemo2 instance;
	
	//方法同步(synchronized),调用效率低
	public static synchronized SingletonDemo2 getInstance()
	{
		if(instance == null)
		{
			instance = new SingletonDemo2();
		}
		return instance;
	}
}
