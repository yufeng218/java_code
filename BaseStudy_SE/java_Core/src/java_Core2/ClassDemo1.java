package java_Core2;

public class ClassDemo1 {

	public static void main(String[] args) {
		A a1 = new A();
		
		/*
		 * 表示A的类类型 --> A类本身也是一个对象，分析一下：也可以是字节码()
		 */
		Class c1 = A.class;
		Class c2 = a1.getClass();
		System.out.println(c1 == c2);
		//c1、c2都表示了一个对象，这个对象代表这个类
		/*
		 * 一个类就是Class类的一个对象；
		 * 我们称为类类类型，也称为类的字节码；
		 * 不管是c1还是c2都代表了A类的类类型，他们是一样的；
		 */
		
		Class c3 = null;
		try {
			/*
			 * 这种表示方法也代表了动态加载类，
			 * 动态加载类是指在运行时刻加载类而非编译时刻加载；
			 */
			c3 = Class.forName("java_Core2.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);
		
		/*
		 * 我们能不能通过类类型直接获取类的对象，通过c1、c2、c3直接获取A类的对象；
		 */
		try {
			//会调用无参数的构造方法来产生对象；返回Object需要做强制类型转换；
			A aa = (A)c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}

class A{}