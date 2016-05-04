package java_Core2;

public class ClassDemo1 {

	public static void main(String[] args) {
		A a1 = new A();
		
		/*
		 * ��ʾA�������� --> A�౾��Ҳ��һ�����󣬷���һ�£�Ҳ�������ֽ���()
		 */
		Class c1 = A.class;
		Class c2 = a1.getClass();
		System.out.println(c1 == c2);
		//c1��c2����ʾ��һ���������������������
		/*
		 * һ�������Class���һ������
		 * ���ǳ�Ϊ�������ͣ�Ҳ��Ϊ����ֽ��룻
		 * ������c1����c2��������A��������ͣ�������һ���ģ�
		 */
		
		Class c3 = null;
		try {
			/*
			 * ���ֱ�ʾ����Ҳ�����˶�̬�����࣬
			 * ��̬��������ָ������ʱ�̼�������Ǳ���ʱ�̼��أ�
			 */
			c3 = Class.forName("java_Core2.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);
		
		/*
		 * �����ܲ���ͨ��������ֱ�ӻ�ȡ��Ķ���ͨ��c1��c2��c3ֱ�ӻ�ȡA��Ķ���
		 */
		try {
			//������޲����Ĺ��췽�����������󣻷���Object��Ҫ��ǿ������ת����
			A aa = (A)c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}

class A{}