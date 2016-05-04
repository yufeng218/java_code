package java_Core2;

import java.lang.reflect.Field;

public class FieldReflectDemo3 {
	public static void main(String[] args) {
		
		User u = new User("zhangsan",20);
		System.out.println(getSql(u));
	}
	
	/**
	 * �����insert into ���� (����1������2��...) values (?,?,...)��
	 * @param obj
	 * @return
	 */
	public static String getSql(Object obj){
		Class c = obj.getClass();
		StringBuffer out = new StringBuffer();
		out.append("insert into ");
		out.append(c.getSimpleName());//��ȡ����
		out.append(" (");
		Field[] fields = c.getDeclaredFields();//��ȡ��Ա������ֵ
		out.append(getPropertyName(obj,fields));
		out.append(") values (");
		out.append(getPropertyValue(obj, fields));
		out.append(")");
		return out.toString();
	}
	
	public static String getPropertyName(Object obj,Field[] fields){
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				s.append(fields[i].getName());
				if(i < fields.length-1){
					s.append(",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s.toString();
	}
	public static String getPropertyValue(Object obj,Field[] fields){
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				s.append(fields[i].get(obj));
				if(i < fields.length-1){
					s.append(",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s.toString();
	}
}
