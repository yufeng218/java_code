package java_Core2;

import java.lang.reflect.*;

public class FeildReflectDemo2 {
	public static void main(String[] args) {
		
		User u = new User("zhangsan",20);
		changeValue(u);
		System.out.println(u.getName()+","+u.getAge());
	}
	
	/**
	 * 把obj的字符串成员变量的值都变成大写的，将int型的成员变量值加100
	 * 获取所有成员变量的值，判断成员变量的类型；
	 * @param obj
	 */
	public static void changeValue(Object obj){
		Class c = obj.getClass();
		Field[] field = c.getDeclaredFields(); //获取所有的属性
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true); //设置私有属性可以访问
			try {
				if(field[i].getType() == String.class){
					String str = (String) field[i].get(obj);
					field[i].set(obj, str.toUpperCase());
				}
				else if(field[i].getType() == int.class){
					int n = (Integer) field[i].get(obj);
					field[i].set(obj, n+100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
