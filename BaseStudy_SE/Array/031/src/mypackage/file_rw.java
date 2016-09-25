package mypackage;

import java.io.*;
import java.util.MissingFormatArgumentException;
//import java.io.File;


public class file_rw {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//获取当前根路径
		String root_path = System.getProperty("user.dir");
		String file_path = root_path + File.separator + "src"+ File.separator + "mypackage" + File.separator +"test.txt";
		System.out.println(file_path);
		
		File file = new File(file_path);
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_path)));
		BufferedReader br = new BufferedReader(new FileReader(file_path));
		
		//
		String[] file_con = new String[4];
		String data = null;
		while((data = br.readLine())!=null)
		{
			System.out.println(data); 
		}
		
		
	}

}
