package my.version1;

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
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
	
	
}
