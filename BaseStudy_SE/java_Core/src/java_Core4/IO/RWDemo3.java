package java_Core4.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RWDemo3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		test();
	}
	
	public static void test(){
		try {
			
			BufferedReader br = new BufferedReader(
					new FileReader("E:\\java_IO\\a.txt"));
//			PrintWriter pw = new PrintWriter(
//					new FileOutputStream("E:\\java_IO\\printW.txt"));
			
			//自动刷新缓冲区
			PrintWriter pw = new PrintWriter(
					new FileOutputStream("E:\\java_IO\\printW.txt"),true);
					
			String str = null;
			while((str = br.readLine()) != null){
				System.out.println(str);
				pw.println(str);
//				pw.flush();
			}
			
			br.close();
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
