package java_Core4.IO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SreamDemo4 {

	public static void main(String[] args) {
		
		write();
		read();
	}
	public static void write(){
		
		try {
			/*
			//把1.txt文件作为字节输出流，并且直接可以写java的数据类型；
			DataOutputStream out = new DataOutputStream(
					new FileOutputStream("D:\\1.txt"));
			*/
			
			/*
			//把1.txt文件作为字节输出流，并且先放入缓冲区，并且直接可以写java数据类型
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("D:\\1.txt")));
			*/
			//发现特殊功能的流类都是由基本的流嵌套构造而来，其实都是装饰模式；
			//例如：BufferedOutputStream(FileOutputStream out);
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("E:\\java_IO\\a.txt")));
			out.writeInt(1000);
			out.writeBoolean(true);
			out.writeDouble(10.23);
			out.writeUTF("好lll");
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read(){
			try {
				
				DataInputStream in = new DataInputStream(
						new FileInputStream("E:\\java_IO\\a.txt"));
				
				System.out.println(in.readInt());
				System.out.println(in.readBoolean());
				System.out.println(in.readDouble());
				System.out.println(in.readUTF());
				in.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
