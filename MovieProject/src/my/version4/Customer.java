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
	 * ���֡����õĴ�ӡ
	 */
	public void printMessage()
	{
		double totalPrice = 0; //�Ǹ��ܷ��� 
		int fre = 0;
		Iterator itor = list.interator();
		while(!itor.isDone())
		{
			Rental r = (Rental)itor.getCurrent();
			totalPrice += r.getMovie().getPrice(r.getDays());
			fre += r.getMovie().getFre(r.getDays());
			itor.next();
		}
		System.out.println(this.name+"���ѵĽ���ǣ�"+totalPrice+"����õĻ����ǣ�"+ fre);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

