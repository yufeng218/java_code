package com.my.ssh.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 抽象Action类，专门用于继承
 * 
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable
{
	private static final long serialVersionUID = 1L;
	
	public T model;
	/*
	 * 实例化model对象
	 */
	public BaseAction()
	{
		//得到泛型参数类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取参数化类型的数组
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try
		{
			model = (T) clazz.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel()
	{
		return model;
	}
	
	@Override
	public void prepare() throws Exception{}

}
