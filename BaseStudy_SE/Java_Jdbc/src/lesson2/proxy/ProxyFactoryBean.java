package lesson2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean implements InvocationHandler {
	private Object target; // Ŀ����� ---> ����Ŀ�������κη������ᱻinvoke��������;

	public ProxyFactoryBean(Object target) {
		this.target = target;
	}

	// invoke���ص������Ŀ�����ķ�����ΪMethod����
	/**
	 * ����method Ϊ�������غ����ص�Ŀ�����ķ���
	 *  args���Ƿ����Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("��������");
		method.invoke(target, args); // Ŀ�귽���ĵ���
		System.out.println("�ύ����������쳣�ͻع�����");

		return null;
	}
	
	/**
	 * �����������
	 * @return
	 */
	public Object getProxy() {
		// Ŀ�������������,Ŀ�����Ľӿڣ���������
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
