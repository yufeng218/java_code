package java_Core3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {
	public static void main(String[] args) {
		HashSet<student> list = new HashSet<student>();
		student stu1 = new student("001","zhangsan",22);
		student stu2 = new student("002","lisi",23);
		student stu3 = new student("003","wangwu",24);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("=======================");
		for(student s : list){
			System.out.println(s);
		}
		
		System.out.println("======================");
		
		Iterator<student> itor = list.iterator();
		while(itor.hasNext()){
			System.out.println(itor.next());
		}
		
		System.out.println("=======================");
		//HashSet.add():加入重复的元素会被自动过滤；
		student stu4 = new student("003","wangwu",24);
		list.add(stu4);
		System.out.println(list);
		/*
		 * 重复元素的定义;
		 * 在这个场景中必须用唯一标识对象的属性来重写;
		 * equals和hashCode方法
		 * hashCode方法是一种散列算法，现在不用关心如何去写；
		 * 它和HashSet中数据的存放有直接关系;
		 * 
		 */
		
		
		
	}

}
