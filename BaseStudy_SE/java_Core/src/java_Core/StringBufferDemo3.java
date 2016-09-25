package java_Core;

public class StringBufferDemo3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("hello");
		buffer.append(" world");
		System.out.println(buffer);
		System.out.println("=================================");
		
		long end = System.currentTimeMillis();

	}

}
