package java_Core2;

import java.lang.reflect.Field;

public class FieldReflectDemo1 {

	public static void main(String[] args) {
		User u = new User("zhangsan",30);
		Class c = u.getClass();
		try {
			Field field = c.getDeclaredField("name");
			field.setAccessible(true);
			System.out.println(field.get(u));
			
			field.set(u, "lisi");
			System.out.println(u.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
