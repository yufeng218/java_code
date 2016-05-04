package my.version4;

public class Movie 
{
	public final static int NEW_MOVIE = 1;
	public final static int R_MOVIE = 2;
	public final static int CHILD_MOVIE = 3;
	public Price price;
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
		switch(this.getPriceCode())
		{
			case NEW_MOVIE:
				price = new NewMoviePrice();
				break;
			case CHILD_MOVIE:
				price = new ChildrenMoviePrice();
				break;
			case R_MOVIE:
				price = new RMoviePrice();
				break;
		}
		return price.getPrice(days);
	}
	/**
	 * 计算积分
	 * @param rental TODO
	 * @return
	 */
	public int getFre(int days)
	{
		return price.getFre(days);
	}
	
}
