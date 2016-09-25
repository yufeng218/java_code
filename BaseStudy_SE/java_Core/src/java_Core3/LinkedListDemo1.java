package java_Core3;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListDemo1 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("sdsdsd");
		list.add("heoll");
		list.add("3333");
		System.out.println(list.size());
		
		System.out.println("===============");
		Iterator<String> itor = list.iterator();
		while(itor.hasNext()){
			String a = itor.next();
			System.out.println(a);
		}
		
		
		System.out.println("====================");
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		list.addFirst("first");
		list.addLast("last");
		System.out.println(list);
		
		
	}

}
