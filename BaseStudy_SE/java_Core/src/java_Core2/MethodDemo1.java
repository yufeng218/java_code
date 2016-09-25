package java_Core2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		System.out.println(s1.concat(s2));
		
		/*
		 * 用concat方法的反射来操作
		 */
		Class c1 = s1.getClass(); //String.class; s2.getClass();
		try {
			//获取concat方法
			Method concatMethod = c1.getMethod("concat", new Class[]{String.class});
			
			String ss = (String)concatMethod.invoke(s1, new Object[]{s2});
			System.out.println(ss);
			
			System.out.println("=========================");
			Class c = MethodTest.class;
			MethodTest mt = new MethodTest();
			Method fmethod = c.getMethod("f", new Class[]{});
			fmethod.invoke(mt, new Object[]{});
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		
	}

}


class MethodTest{
	public void f(){
		System.out.println("f...");
	}
	
	public void f(int a,int b){
		System.out.println(a+b);
	}
}
