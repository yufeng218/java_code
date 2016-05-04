package java_Core4.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderDemo2 {
	public static void main(String[] args) {
		
			try {
				BufferedReader br = new BufferedReader(
						new FileReader("E:\\java_IO\\a.txt"));
				BufferedWriter bw = new BufferedWriter(
						new FileWriter("E:\\java_IO\\buffer.txt"));
				
				char[] c = new char[1000];
				String str = null;
				while((str = br.readLine()) != null){
					bw.write(str, 0, str.length());
					bw.newLine();
					bw.flush();
				}
				
				br.close();
				bw.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
	}
}
