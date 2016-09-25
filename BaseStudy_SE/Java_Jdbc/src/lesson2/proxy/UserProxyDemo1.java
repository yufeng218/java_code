package lesson2.proxy;

public class UserProxyDemo1 {

	public static void main(String[] args) {
		
		UserServiceImpl us = new UserServiceImpl();
		UserServiceProxy uproxy = new UserServiceProxy();
//		us.insertUser();
//		us.updateUser();
		uproxy.setUserService(us);
		uproxy.insertUser();
		uproxy.updateUser();
		
	}

}
