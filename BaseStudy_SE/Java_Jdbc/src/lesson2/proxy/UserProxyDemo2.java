package lesson2.proxy;

/**
 * ��̬����Ĳ���
 * 
 * �ӿڣ�UserService
 * ʵ�ֵ��ࣺUserServiceImpl
 * ������ࣺProxyFactoryBean
 * 
 * @author pc
 *
 */

public class UserProxyDemo2 {

	public static void main(String[] args) {
		
		//����Ŀ�����
		UserService us = new UserServiceImpl();
		
		//����Ŀ�����Ĵ���
		ProxyFactoryBean pfb = new ProxyFactoryBean(us);
		
		//���ɴ������
		UserService  usProxy = (UserService)pfb.getProxy();
		usProxy.insertUser();
		usProxy.updateUser();
	}

}
