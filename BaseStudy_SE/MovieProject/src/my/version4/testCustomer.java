package my.version4;

public class testCustomer {

	public static void main(String[] args) {
		
		Movie m1 = new Movie("老男孩",Movie.R_MOVIE);
		Movie m2 = new Movie("休息",Movie.CHILD_MOVIE);
		Rental r1 = new Rental(m1,2);
		Rental r2 = new Rental(m2,1);
		
		Customer c1 = new Customer("张三");
		c1.add(r1);
		c1.add(r2);
		c1.add(r2);
		c1.printMessage();
	}

}
