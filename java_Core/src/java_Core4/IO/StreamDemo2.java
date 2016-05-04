package java_Core4.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo2 {

	public static void main(String[] args) {
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("D:\\ͼƬ\\dd.jpg"));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("D:\\ͼƬ\\fa.jpg"));
			
			byte[] b = new byte[100];
			int ms;
			while((ms = bis.read(b, 0, b.length)) != -1){
				bos.write(b, 0, ms);
				bos.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
