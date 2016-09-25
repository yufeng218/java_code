package my.version2;

public class Customer 
{
	private String name;
	public Customer(String name){
		this.name = name;
	}
	myArrayList list = new myArrayList();
	public void add(Rental rental){
		if(rental == null) return;
		if(list.contains(rental)) return;
		list.add(rental);
	}
	
	/**
	 * 积分、费用的打印
	 */
	public void printMessage()
	{
		double totalPrice = 0; //那个总费用 
		int fre = 0;
		Iterator itor = list.interator();
		while(!itor.isDone())
		{
			Rental r = (Rental)itor.getCurrent();
			totalPrice += getPrice(r);
			fre += getFre(r);
			itor.next();
		}
		System.out.println(this.name+"消费的金额是："+totalPrice+"，获得的积分是："+ fre);
	}
	
	/**
	 * 计算费用
	 * @param result
	 * @param r
	 * @return
	 */
	private double getPrice(Rental r) 
	{
		double result = 0;
		switch(r.getMovie().getPriceCode())
		{
			case Movie.NEW_MOVIE:
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
		return result;
	}
	
	/**
	 * 计算积分
	 * @param r
	 * @return
	 */
	public int getFre(Rental r)
	{
		if(r.getMovie().getPriceCode() == Movie.NEW_MOVIE 
				&& r.getDays()>1)
			return 2;
		return 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

