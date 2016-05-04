package java_Core2;

import java.lang.reflect.*;

public class FeildReflectDemo2 {
	public static void main(String[] args) {
		
		User u = new User("zhangsan",20);
		changeValue(u);
		System.out.println(u.getName()+","+u.getAge());
	}
	
	/**
	 * ��obj���ַ�����Ա������ֵ����ɴ�д�ģ���int�͵ĳ�Ա����ֵ��100
	 * ��ȡ���г�Ա������ֵ���жϳ�Ա���������ͣ�
	 * @param obj
	 */
	public static void changeValue(Object obj){
		Class c = obj.getClass();
		Field[] field = c.getDeclaredFields(); //��ȡ���е�����
		for (int i = 0; i < field.length; i++) {
			field[i].setAccessible(true); //����˽�����Կ��Է���
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
