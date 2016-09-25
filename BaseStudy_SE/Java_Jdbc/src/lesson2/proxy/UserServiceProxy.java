package lesson2.proxy;

public class UserServiceProxy implements UserService{
	private UserServiceImpl userService;
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@Override
	public void insertUser() {
		System.out.println("开启事务");
		userService.insertUser();
		System.out.println("提交事务，如果有异常就回滚事务");
	}

	@Override
	public void updateUser() {
		System.out.println("开启事务");
		userService.updateUser();
		System.out.println("提交事务，如果有异常就回滚事务");
	}
	
	
	
}
