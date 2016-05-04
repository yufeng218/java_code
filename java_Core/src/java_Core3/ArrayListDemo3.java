package java_Core3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo3 {
	public static void main(String[] args) {
		/*
		 * 泛型操作，指明Products容器中只存放Product类型的实例；
		 * 优点：在编译阶段防止存入其他类型的实例；
		 * 		实际操作中不需要进行强制类型转换；
		 */
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product pro1 = new Product("001","java课程",10000);
		Product pro2 = new Product("002","android课程",12000);
		Product pro3 = new Product("003","ui课程",12000);
		//products.add("hello"); //编译出错
		products.add(pro1);
		products.add(pro2);
		products.add(pro3);

		System.out.println("======迭代器遍历=========");
		Iterator itor = products.iterator();
		while(itor.hasNext())
		{
			Product pro = (Product)itor.next();
			System.out.println(pro);
		}
		
		
		
	}
}
