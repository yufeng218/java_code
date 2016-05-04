package java_Core4.IO;

import java.io.File;

public class FileDemo1 {
	public static void main(String[] args) {
		File file = new File("E:\\java_exam\\woYing");
		System.out.println(file.exists());
		//列出目录下所有的目录和文件名，返回字符串的数组
		for(String x : file.list())
			System.out.print(x + " ");
		/*
		File f = new File("E:\\aa\\bb\\cc");
		if(!f.exists()){
			f.mkdirs();
		} else {
			f.delete();
		}*/
		
		File f = new File("E:\\aa\\bb\\cc", "dd");
		if(!f.exists()){
			f.mkdirs();
		} else {
			f.delete();
		}
		
		System.out.println("======================");
		File f1 = new File("E:\\aa\\bb\\cc", "1.txt");
		System.out.println(f1.getAbsoluteFile());
		System.out.println(f1.getAbsolutePath());
		
		System.out.println(f1.getName());//返回路径上的最后一个层级
		
		//getParentFile()得到父目录的字符串
		System.out.println(f1.getParent());
		//getParentFile()得到父目录的File对象
		System.out.println(f1.getParentFile());
	}

}
