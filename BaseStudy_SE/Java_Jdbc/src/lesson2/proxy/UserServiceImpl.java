package lesson2.proxy;

public class UserServiceImpl implements UserService{

	@Override
	public void insertUser() {
		System.out.println("ͨ�������һ��Dao��������������û���ҵ��");
	}

	@Override
	public void updateUser() {
		System.out.println("ͨ�������һ��Dao����������޸��û���ҵ��");
	}
	
	
	
}
