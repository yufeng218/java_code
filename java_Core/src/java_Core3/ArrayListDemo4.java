package java_Core3;

import java.util.ArrayList;
import java.lang.reflect.*;

public class ArrayListDemo4 {

	public static void main(String[] args) {
		
		ArrayList<Product> list1 = new ArrayList<Product>();
		ArrayList list2 = new ArrayList();
		
		//�����true˵����������һ���ģ���ô�������ȥ���ͻ���
		System.out.println(list1.getClass() == list2.getClass());
		
		try {
			Method method = list1.getClass().getMethod("add", new Class[]{Object.class});
			method.invoke(list1, new Object[]{"heoll world"});
			method.invoke(list1, new Object[]{100});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list1);
		
	}

}
