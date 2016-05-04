package java_Core3;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo1 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("hello");
		v.add("world");
		System.out.println(v.size());
		System.out.println(v);
		
		System.out.println("======================");
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		
		System.out.println("=======================");
		v.addElement("bye");
		System.out.println(v);
		
	}

}
