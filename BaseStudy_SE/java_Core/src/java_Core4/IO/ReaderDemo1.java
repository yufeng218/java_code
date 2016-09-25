package java_Core4.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReaderDemo1 {
	public static void main(String[] args) {
		
		test();
		
	}
	
	public static void test(){
		try {
			
			InputStreamReader in = new InputStreamReader(
					new FileInputStream("E:\\java_IO\\b.txt"),"utf-8");
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream("E:\\java_IO\\writer.txt"),"utf-8");
			
			char[] b = new char[1000];
			int c;
			while((c = in.read(b, 0, b.length)) != -1){
				String str = new String(b, 0, c);
				//System.out.println(str);
				out.write(str);
				out.flush();
			}
			
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
