package com.my.beans.cycle;

public class Car {
	private String brand;
	
	public Car()
	{
		System.out.println("Car's constructor...");
	}
	
	public void init2()
	{
		System.out.println("init...");
	}
	
	public void destory()
	{
		System.out.println("destory...");
	}
	
	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		System.out.println("settBrand...");
		this.brand = brand;
	}

	@Override
	public String toString()
	{
		return "Car [brand=" + brand + "]";
	}
	
	
}
