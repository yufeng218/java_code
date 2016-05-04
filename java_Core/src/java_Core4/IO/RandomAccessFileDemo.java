package java_Core4.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) {
		
		test();
	}
	
	public static void test(){
		try {
			
			RandomAccessFile raf = new RandomAccessFile(
					"E:\\java_IO\\raf.daf", "rw");
			System.out.println(raf.getFilePointer()); //获取文件中当前偏移量
			raf.writeInt(1000);
			System.out.println(raf.getFilePointer());
			raf.write(1000 >> 24);
			raf.write(1000 >> 16);
			raf.write(1000 >> 8);
			raf.write(1000);
			raf.writeUTF("hello");
			
			
			raf.seek(0);
			int a = raf.readInt();
			raf.seek(8); //设置偏移量为8,然后开始读取或写入
			String b = raf.readUTF();
			System.out.println(a);
			System.out.println(b);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
