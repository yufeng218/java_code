package java_Core2;

import java.lang.reflect.Method;

public class MethodReflectDemo3 {

	public static void main(String[] args) {
		User u = new User("zhangsan",30);
		String a = (String)getValueByPropertyName("name",u);
		int b = (Integer)getValueByPropertyName("age", u);
		System.out.println(a);
		System.out.println(b);
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param obj
	 * @return
	 */
	public static Object getValueByPropertyName(String propertyName,Object obj){
		/*
		 * 标准的javaBean都有get和set方法
		 * 根据属性名获取get方法，然后通过get方法的反射操作即可
		 */
		Class c = obj.getClass();
		String methodName = "get" + propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		try {
			Method m1 = c.getMethod(methodName, new Class[]{});
			Object result = m1.invoke(obj, new Object[]{});
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
