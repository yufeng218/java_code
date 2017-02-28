package com.my.factory.method;

public class Clinet
{
	public static void main(String[] args)
	{
		Car c1 = new AudiFactory().createCar();
		Car c2 = new BydFactory().createCar();
		
		c1.run();
		c2.run();
	}
}
