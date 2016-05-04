package java_Core;

public class StringDemo1 {

	public static void main(String[] args) {
		char[] chars = {'a','b','d','c','m'};
		String str1 = new String(chars);
		System.out.println(str1);
		
		String s1 = new String(chars,2,2);
		System.out.println(s1);
		
		String s2 = new String("helloWord！");
		System.out.println(s2);

		//特殊的构造方式,直接赋值
		String s3 = "hello!"; 
		String s4 = "hello!";
		System.out.println(s3 == s4);
		/*
		 * //字符串常量，
		 * 通过构造函数new的一定会产生新的空间，通过直接赋值的方式不一定产生新的空间；
		 * 其实是一种设计模式，称作享元模式 
		 */
		
		String s5 = "a"+"b"+"c"; //直接等价于"abc"
	}

}
