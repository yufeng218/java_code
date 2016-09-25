package java_Core3.Map;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("dd");
		list.add("ee");
		list.add("bb");
		list.add("cc");
		System.out.println(list);
		
		System.out.println("======== 集合中元素的倒置 =======");
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("======== 排序(按照字母)=======");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("======== 排序的同时倒叙  =============");
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(list);
	}

}
