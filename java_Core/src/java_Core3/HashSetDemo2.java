package java_Core3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo2 {
	public static void main(String[] args) {
		HashSet<student> list = new HashSet<student>();
		student stu1 = new student("001","zhangsan",22);
		student stu2 = new student("002","lisi",23);
		student stu3 = new student("003","wangwu",24);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println(list.size());
		
		/*
		 * HashSet存放元素的位置是和对象hashCode算法得到的值相关的。
		 * 那么查找元素时，也要根据这个算法的值找到相关位置，然后移除元素；
		 * 如果没有该元素存在，remove()方法返回false；
		 * 如果跟该算法相关的属性值在放入容器后被修改了，
		 * 意味着hashCode算法得到的值和之前放入容器时不一样了，找对象的位置就发生了改变，
		 * 从而找不到对象，导致元素不能被移除，久而久之机会产生内存泄漏；
		 */
		
		stu1.setNo("000");//修改stu1对象后，对象不能移除
		
		//删除stu1
		list.remove(stu1);
		System.out.println(list.size());
		
	}
}
