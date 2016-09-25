package java_Core5.Tread;

public class UserService {
	private static ThreadLocal<UserService> tl = new ThreadLocal<UserService>();
	private UserService(){}
	public static UserService getInstance(){
		UserService u = tl.get();
		if(u == null){
			u = new UserService();
			tl.set(u);
		}
		return u;
	}
	
}
