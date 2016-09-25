package java_Core4.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class StreamDemo1 {

	public static void main(String[] args) {
		//test1();
		test2();
		//test3();
	}
	
	//所有的IO操作都有IOException产生
	public static void test1(){
		try {
			FileInputStream in = new FileInputStream(
			    "E:\\java_exam\\first\\src\\firstOne\\javaStudy1.java");
			FileOutputStream out = new FileOutputStream(
					"E:\\java_exam\\first\\src\\firstOne\\a.txt");
			
			int c;
			while((c = in.read()) != -1)
			{
				out.write(c);
				System.out.print((char)c);
			}
			in.close(); //关闭文件最好在finally里面
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void test2(){
		try {
			FileInputStream in = new FileInputStream(
				"E:\\java_exam\\first\\src\\firstOne\\javaStudy1.java");
			FileOutputStream out = new FileOutputStream(
					"E:\\java_exam\\first\\src\\firstOne\\b.txt");
			
			byte[] b = new byte[1024*5];
			//往b字节数组中放，从第0位开始最多放b.length个
//			int bytes = in.read(b, 0, b.length);
//			String str = new String(b, 0, bytes);
//			System.out.println(str);
			int bytes;
			while((bytes = in.read(b, 0, b.length)) != -1){
				String str = new String(b, 0, bytes);
				System.out.println(str);
				out.write(b, 0, bytes);
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void test3(){
		try {
			FileInputStream in = new FileInputStream(
					"E:\\java_exam\\first\\src\\firstOne\\javaStudy1.java");
			/*
			 * 如果需要读取的文件很大，那么在内存中开辟的空间就很大
			 */
			int length =in.available(); //返回可读的字节数
			byte[] b = new byte[length];
			in.read(b);
			String s = new String(b);
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
