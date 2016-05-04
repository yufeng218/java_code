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
	
	//���е�IO��������IOException����
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
			in.close(); //�ر��ļ������finally����
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
			//��b�ֽ������зţ��ӵ�0λ��ʼ����b.length��
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
			 * �����Ҫ��ȡ���ļ��ܴ���ô���ڴ��п��ٵĿռ�ͺܴ�
			 */
			int length =in.available(); //���ؿɶ����ֽ���
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
