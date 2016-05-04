package java_Core3;

import java.util.ArrayList;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Product p1 = new Product("001","java课程",10000);
		Product p2 = new Product("002","java课程",20000);
		Product p3 = new Product("001","java课程",10000);
		list.add(p1);
		list.add(p2);
		System.out.println(list.contains(p3));
		System.out.println(p1.equals(p3));
		
		System.out.println("========================");
		
		
		//移除元素
		System.out.println(list.remove(0));
		System.out.println(list.remove(p2));
		System.out.println(list);
	}

}
