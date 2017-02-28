package com.my.factory.abstractFactory;

public interface Seat
{
	void message();
}

class LuxurySeat implements Seat
{

	@Override
	public void message()
	{
		System.out.println("可以自动按摩!");
	}
	
}

class LowSeat implements Seat
{

	@Override
	public void message()
	{
		System.out.println("不可以自动按摩!");
	}
	
}

