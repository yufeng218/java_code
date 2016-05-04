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
	 * 如果obj对象为非数组直接打印toString;
	 * 如果obj为数组，打印数组中的每一个元素
	 * @param obj
	 */
	public static void printObject(Object obj){
		Class c = obj.getClass();
		//判断是否为数组
		if(c.isArray()){
			int length = Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				//获取数组中的某个元素
				Object objSon = Array.get(obj, i);
				//数组中的某个元素可能是一个数组，递归调用
				printObject(objSon);
			}
		} else {
			System.out.println(obj);
		}
	}

}
