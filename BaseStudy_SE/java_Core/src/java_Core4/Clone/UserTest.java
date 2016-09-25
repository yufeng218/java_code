package java_Core4.Clone;

public class UserTest {

	public static void main(String[] args) {
		
		Address a = new Address();
		User u = new User();
		u.setAddress(a);
		try {
			
			User u1 = (User)u.clone();
			User u2 = (User)u.deepClone();
			System.out.println(u == u1);
			System.out.println(u.getAddress() == u1.getAddress());
			
			System.out.println("==================");
			System.out.println(u == u2);
			System.out.println(u.getAddress() == u2.getAddress());
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
