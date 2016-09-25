package java_Core4.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class RWDDemo4 {

	public static void main(String[] args) {
		
		test();
		
	}
	/**
	 * 从键盘一次读一行，读到end结束；
	 * BufferedReader能一次读一行
	 */
	public static void test(){
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(
					new FileOutputStream("E:\\java_IO\\printw2.txt"),true);
//			PrintWriter pw = new PrintWriter(System.out);
			while(true){
				String str = br.readLine();
				System.out.println(str);
				pw.println(str);
				if(str.equals("end")) break;
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
