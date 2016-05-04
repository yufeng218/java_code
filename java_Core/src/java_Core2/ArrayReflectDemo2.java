package java_Core2;

import java.lang.reflect.Array;
import java.util.Arrays;
public class ArrayReflectDemo2 {
	public static void main(String[] args) {
		
		String[][] ss = {{"a","b","c"},{"1","2","3"}};
		int[] s = {7,8,9,10,11};
		printObject(ss);
		System.out.println("=================");
		printObject(s);
		
		System.out.println("===============");
		System.out.println(Array.getLength(s));
	}
	
	public static void test(Object obj){
		Class c = obj.getClass();
		System.out.println(c.isArray());
	}
	
	/**
	 * ���obj����Ϊ������ֱ�Ӵ�ӡtoString;
	 * ���objΪ���飬��ӡ�����е�ÿһ��Ԫ��
	 * @param obj
	 */
	public static void printObject(Object obj){
		Class c = obj.getClass();
		//�ж��Ƿ�Ϊ����
		if(c.isArray()){
			int length = Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				//��ȡ�����е�ĳ��Ԫ��
				Object objSon = Array.get(obj, i);
				//�����е�ĳ��Ԫ�ؿ�����һ�����飬�ݹ����
				printObject(objSon);
			}
		} else {
			System.out.println(obj);
		}
	}

}
