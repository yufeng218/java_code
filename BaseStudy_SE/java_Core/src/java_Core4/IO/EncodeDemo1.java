package java_Core4.IO;

import java.io.UnsupportedEncodingException;


public class EncodeDemo1 {
	public static void main(String[] args) {
		//java语言内部一个字符占用2个字节，不管是中文还是英文
		String s = "ABC沃";
		byte[] b = s.getBytes();//默认会有项目的编码进行转换
		for (byte c : b) {
			System.out.print(Integer.toHexString(c & 0xff) + " ");
		}
		
		System.out.println("=====================");
		try {
			byte[] b1 = s.getBytes("gbk");
			System.out.println(b1.length);
			for (byte c : b1) {
				System.out.print(Integer.toHexString(c&0xFF) + " ");
			}//gbk编码1个英文占用一个字节，一个中文占用2个字节；

			System.out.println("======================");
			byte[] b2 = s.getBytes("utf-8");
			System.out.println(b2.length);
			for (byte c : b2) {
				System.out.print(Integer.toHexString(c & 0xFF) + " ");
			}
		
			System.out.println("=======================");
			byte[] b3 = s.getBytes("utf-16be");
			System.out.println(b3.length);
			for (byte c : b3) {
				System.out.print(Integer.toHexString(c&0xFF) + " ");
			}
			
			System.out.println("====================");
			String s1 = new String(b1, "gbk");
			System.out.println(s1);
			
			String s2 = new String(b2, "gbk");//b2是utf-8编码存入的
			System.out.println(s2);
			String s3 = new String(b2, "utf-8");//b2是utf-8编码存入的
			System.out.println(s3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
