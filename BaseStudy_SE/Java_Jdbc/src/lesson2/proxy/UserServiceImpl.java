package lesson2.proxy;

public class UserServiceImpl implements UserService{

	@Override
	public void insertUser() {
		System.out.println("通过多个或一个Dao操作来完成增加用户的业务");
	}

	@Override
	public void updateUser() {
		System.out.println("通过多个或一个Dao操作来完成修改用户的业务");
	}
	
	
	
}
