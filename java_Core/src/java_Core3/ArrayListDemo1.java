package java_Core3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		Product pro1 = new Product("001","java�γ�",10000);
		Product pro2 = new Product("002","android�γ�",12000);
		Product pro3 = new Product("003","ui�γ�",12000);
		ArrayList list = new ArrayList();
		list.add(pro1); //���Ԫ��
		list.add(pro2);
		list.add(pro3);
		System.out.println(list);//��ӡ�������󣬴�ӡ����������ÿ��Ԫ�ص�toString
		System.out.println(list.size());//��ȡ��������ЧԪ�ظ���
		
		//ɾ��ĳ��Ԫ��
		pro1.setName("sds");
		list.remove(pro1);
		System.out.println(list.size());//��ȡ��������ЧԪ�ظ���
		
		/*
		//��ȡĳ��Ԫ��
		Product p1 = (Product)list.get(2);
		
		//��������
		//1.forѭ��
		for (int i = 0; i < list.size(); i++) {
			Product p2 = (Product)list.get(i);
			System.out.println(p2);
		}*/
		
		/*2.�������ı���
		 * �����һ���ۼ�����Ӧ���ṩ���ʾۼ���ĳ��Ԫ�غͱ�������Ԫ�صķ�ʽ
		 * 
		 * ���������ģʽ
		 * java.util.Iterator
		 */
		/*
		System.out.println("======= ������ =====");
		Iterator itor = list.iterator();
		while(itor.hasNext()){
			Product p3 = (Product)itor.next();
			System.out.println(p3);
		}*/
	}

}
