package java_Core2;

import java.lang.reflect.Method;
public class ArrayReflectDemo1 {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		Class c = a.getClass();
		System.out.println(c.getName());
		
		//数组的类类型只和数组的类型和维数有关；
		int[] b = {3,4,5};
		Class c1 = b.getClass();
		System.out.println(c1 == c);
		String[][] str = {{},{}};
		System.out.println(String[][].class == str.getClass());
		
		//获取test方法
		try {
			Class c2 = B.class;
			Method method = c2.getMethod("test", new Class[]{String[].class,int[].class});
			method.invoke(c2.newInstance(), new Object[]{new String[]{"a","b"},new int[]{1,2,3}});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class B{
	public void test(String[] a, int[] b){
		for (String i : a) {
			System.out.print(i);
		}
		for (int i : b) {
			System.out.print(i);
		}
	}
}
