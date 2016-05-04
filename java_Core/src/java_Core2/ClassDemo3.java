package java_Core2;

import java.lang.reflect.*;

public class ClassDemo3 {

	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * getMethods获取了所有的public的方法；
		 * getDeclaredMethod()是自己声明的方法，不问访问权限
		 */
		Class c = Class.forName("java.lang.String");
		
		//获取方法的返回值类型的类类型
		Method[] ms = c.getMethods();
		for(Method x : ms){
			String type = x.getReturnType().getName();
			String name = x.getName();
			System.out.print(type + " " + name +"(");
			
			//获取的是方法的参数列表的类类型
			Class[] paraType = x.getParameterTypes();
			for(Class y : paraType){
				System.out.print(y+",");
			}
			System.out.println(")");
		}
		
		System.out.println("=========== 成员变量 ================");
		/*
		 * 成员变量也是java.lang.reflect.Field的对象；
		 * getDeclaredFields获取所有自己声明的成员变量；
		 * getFeilds方法获取所有的public的成员变量；
		 */
		Field[] fs = c.getDeclaredFields();
		for(Field x: fs){
			//获取成员变量的类类型
			Class feildType = x.getType();
			String type = feildType.getName();
			String name = x.getName();
			System.out.println(""+type+" "+name);
		}
		
		System.out.println("=========== 构造方法 ================");
		/*
		 * getConstructors获取所有自己声明的构造方法
		 */
		//c = Class.forName("javax.swing.JButton");
		Constructor[] cs = c.getConstructors();
		for(Constructor x: cs){
			System.out.print(x.getName()+"(");
			Class[] paraType = x.getParameterTypes();
			for(Class y : paraType){
				System.out.print(y.getName());
			}
			System.out.println(")");
		}
	}

}
