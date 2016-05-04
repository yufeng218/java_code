package java_Core3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		Product pro1 = new Product("001","java课程",10000);
		Product pro2 = new Product("002","android课程",12000);
		Product pro3 = new Product("003","ui课程",12000);
		ArrayList list = new ArrayList();
		list.add(pro1); //添加元素
		list.add(pro2);
		list.add(pro3);
		System.out.println(list);//打印容器对象，打印容纳容器的每个元素的toString
		System.out.println(list.size());//获取容器的有效元素个数
		
		//删除某个元素
		pro1.setName("sds");
		list.remove(pro1);
		System.out.println(list.size());//获取容器的有效元素个数
		
		/*
		//获取某个元素
		Product p1 = (Product)list.get(2);
		
		//遍历容器
		//1.for循环
		for (int i = 0; i < list.size(); i++) {
			Product p2 = (Product)list.get(i);
			System.out.println(p2);
		}*/
		
		/*2.迭代器的遍历
		 * 如果有一个聚集，就应该提供访问聚集中某个元素和遍历所有元素的方式
		 * 
		 * 迭代器设计模式
		 * java.util.Iterator
		 */
		/*
		System.out.println("======= 迭代器 =====");
		Iterator itor = list.iterator();
		while(itor.hasNext()){
			Product p3 = (Product)itor.next();
			System.out.println(p3);
		}*/
	}

}
