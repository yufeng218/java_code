package java_Core3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo3 {
	public static void main(String[] args) {
		/*
		 * ���Ͳ�����ָ��Products������ֻ���Product���͵�ʵ����
		 * �ŵ㣺�ڱ���׶η�ֹ�����������͵�ʵ����
		 * 		ʵ�ʲ����в���Ҫ����ǿ������ת����
		 */
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product pro1 = new Product("001","java�γ�",10000);
		Product pro2 = new Product("002","android�γ�",12000);
		Product pro3 = new Product("003","ui�γ�",12000);
		//products.add("hello"); //�������
		products.add(pro1);
		products.add(pro2);
		products.add(pro3);

		System.out.println("======����������=========");
		Iterator itor = products.iterator();
		while(itor.hasNext())
		{
			Product pro = (Product)itor.next();
			System.out.println(pro);
		}
		
		
		
	}
}
