package lesson2.proxy;

/**
 * 动态代理的测试
 * 
 * 接口：UserService
 * 实现的类：UserServiceImpl
 * 代理的类：ProxyFactoryBean
 * 
 * @author pc
 *
 */

public class UserProxyDemo2 {

	public static void main(String[] args) {
		
		//生成目标对象
		UserService us = new UserServiceImpl();
		
		//建立目标对象的代理
		ProxyFactoryBean pfb = new ProxyFactoryBean(us);
		
		//生成代理对象
		UserService  usProxy = (UserService)pfb.getProxy();
		usProxy.insertUser();
		usProxy.updateUser();
	}

}
