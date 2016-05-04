package my.version1;

public class Customer 
{
	private String name;
	public Customer(String name){
		this.name = name;
	}
	
	Rental[] rs = new Rental[5];
	private int index = 0;
	public void addRental(Rental rental) throws ArrayIndexOutOfBoundsException
	{
		rs[index++] = rental;
		if(index == rs.length)
			throw new ArrayIndexOutOfBoundsException();
	}
	
	/**
	 * 积分、费用的打印
	 */
	public void printMessage()
	{
		double totalPrice = 0;
		double result = 0;
		int fre = 0;
		for(int i=0;i<index;i++)
		{
			Rental r = rs[i];
			switch(r.getMovie().getPriceCode())
			{
				case Movie.NEW_MOVIE:
					if(r.getDays()>1)
						fre++;
					result = r.getDays()*3;
					break;
				case Movie.CHILD_MOVIE:
					if(r.getDays()<=3)
						result = 1.5;
					else if(r.getDays()>3)
						result = (r.getDays()-3)*1.5 + 1.5;
					break;
				case Movie.R_MOVIE:
					if(r.getDays()<=2)
						result = 2;
					else if(r.getDays()>2)
						result = (r.getDays()-2)*1.5 + 2;
					break;
			}
			totalPrice += result;
			fre++;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
