package my.version4;

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
			totalPrice += r.getMovie().getPrice(r.getDays());
			fre += r.getMovie().getFre(r.getDays());
			itor.next();
		}
		System.out.println(this.name+"消费的金额是："+totalPrice+"，获得的积分是："+ fre);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

