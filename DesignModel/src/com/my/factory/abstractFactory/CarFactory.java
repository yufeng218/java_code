package com.my.factory.abstractFactory;

public interface CarFactory
{
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}

/**
 * 高端工厂类
 * @author pc
 *
 */
class LuxuryCarFactory implements CarFactory
{

	@Override
	public Engine createEngine()
	{
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat()
	{
		return new LuxurySeat();
	}

	@Override
	public Tyre createTyre()
	{
		return new LuxuryTyre();
	}
	
}

/**
 * 低端工厂类
 * @author pc
 *
 */
class LowCarFactory implements CarFactory
{

	@Override
	public Engine createEngine()
	{
		return new LowEngine();
	}

	@Override
	public Seat createSeat()
	{
		return new LowSeat();
	}

	@Override
	public Tyre createTyre()
	{
		return new LowTyre();
	}
	
}
