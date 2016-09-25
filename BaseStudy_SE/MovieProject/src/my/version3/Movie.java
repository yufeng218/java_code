package my.version3;

public class Movie 
{
	public final static int NEW_MOVIE = 1;
	public final static int R_MOVIE = 2;
	public final static int CHILD_MOVIE = 3;
	private String name;
	private int priceCode;
	
	public Movie(){}
	public Movie(String name) {
		this.name = name;
	}
	public Movie(String name, int priceCode) {
		this.name = name;
		this.priceCode = priceCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
	@Override
	public String toString() {
		return this.name;
	}
	/**
	 * 计算费用
	 * @param result
	 * @param rental TODO
	 * @return
	 */
	public double getPrice(int days) 
	{
		double result = 0;
		switch(this.getPriceCode())
		{
			case NEW_MOVIE:
				result = days*3;
				break;
			case CHILD_MOVIE:
				if(days<=3)
					result = 1.5;
				else if(days>3)
					result = (days-3)*1.5 + 1.5;
				break;
			case R_MOVIE:
				if(days<=2)
					result = 2;
				else if(days>2)
					result = (days-2)*1.5 + 2;
				break;
		}
		return result;
	}
	/**
	 * 计算积分
	 * @param rental TODO
	 * @return
	 */
	public int getFre(int days)
	{
		if(this.getPriceCode() == NEW_MOVIE 
				&& days>1)
			return 2;
		return 1;
	}
	
}
