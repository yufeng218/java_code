package lesson2.proxy;

public class UserServiceProxy implements UserService{
	private UserServiceImpl userService;
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@Override
	public void insertUser() {
		System.out.println("��������");
		userService.insertUser();
		System.out.println("�ύ����������쳣�ͻع�����");
	}

	@Override
	public void updateUser() {
		System.out.println("��������");
		userService.updateUser();
		System.out.println("�ύ����������쳣�ͻع�����");
	}
	
	
	
}
