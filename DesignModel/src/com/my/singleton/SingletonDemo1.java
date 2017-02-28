package com.my.singleton;

/**
 * 饿汉式单例模式
 * @author pc
 *
 */

public class SingletonDemo1
{
	//私有化构造器
	private SingletonDemo1(){}
	
	//类初始化时立即加载这个对象(没有延时加载的优势); 类加载时是天然的线程安全的，所以使线程安全的
	private static SingletonDemo1 instance = new SingletonDemo1();
	
	//方法没有同步(synchronized),调用效率高
	public static SingletonDemo1 getInstance()
	{
		return instance;
	}
}
