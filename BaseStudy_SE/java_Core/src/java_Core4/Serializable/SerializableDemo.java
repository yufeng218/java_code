package java_Core4.Serializable;

import java.io.Serializable;

public class SerializableDemo {
	public static void main(String[] args) {
		
	}
}

class A implements Serializable{
	A(){System.out.println("a...");}
}
	
class B extends A{
	B(){System.out.println("b...");}
}

class C extends B{
	C(){System.out.println("c...");}
}


