package java_Core;

import java.util.*;
public class SystemDemo1 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		System.out.println(a);
		
		long b = new Date().getTime();
		System.out.println(b);
	}

}
