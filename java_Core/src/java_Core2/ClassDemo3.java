package java_Core2;

import java.lang.reflect.*;

public class ClassDemo3 {

	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * getMethods��ȡ�����е�public�ķ�����
		 * getDeclaredMethod()���Լ������ķ��������ʷ���Ȩ��
		 */
		Class c = Class.forName("java.lang.String");
		
		//��ȡ�����ķ���ֵ���͵�������
		Method[] ms = c.getMethods();
		for(Method x : ms){
			String type = x.getReturnType().getName();
			String name = x.getName();
			System.out.print(type + " " + name +"(");
			
			//��ȡ���Ƿ����Ĳ����б��������
			Class[] paraType = x.getParameterTypes();
			for(Class y : paraType){
				System.out.print(y+",");
			}
			System.out.println(")");
		}
		
		System.out.println("=========== ��Ա���� ================");
		/*
		 * ��Ա����Ҳ��java.lang.reflect.Field�Ķ���
		 * getDeclaredFields��ȡ�����Լ������ĳ�Ա������
		 * getFeilds������ȡ���е�public�ĳ�Ա������
		 */
		Field[] fs = c.getDeclaredFields();
		for(Field x: fs){
			//��ȡ��Ա������������
			Class feildType = x.getType();
			String type = feildType.getName();
			String name = x.getName();
			System.out.println(""+type+" "+name);
		}
		
		System.out.println("=========== ���췽�� ================");
		/*
		 * getConstructors��ȡ�����Լ������Ĺ��췽��
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
