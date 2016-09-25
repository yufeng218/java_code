package com.my.beans.spel;

import com.my.beans.spel.Car;

public class Person
{
	private String name;
	private Car car;

	// 引用address的city属性
	private String city;

	// 根据 Car 的 price 确定 info; car 的 price >=30W为金领，否则白领；
	private String info;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Car getCar()
	{
		return car;
	}

	public void setCar(Car car)
	{
		this.car = car;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", car=" + car + ", city=" + city
				+ ", info=" + info + "]";
	}
	
}
