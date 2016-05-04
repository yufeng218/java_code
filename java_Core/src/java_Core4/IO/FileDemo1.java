package java_Core4.IO;

import java.io.File;

public class FileDemo1 {
	public static void main(String[] args) {
		File file = new File("E:\\java_exam\\woYing");
		System.out.println(file.exists());
		//�г�Ŀ¼�����е�Ŀ¼���ļ����������ַ���������
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
		
		System.out.println(f1.getName());//����·���ϵ����һ���㼶
		
		//getParentFile()�õ���Ŀ¼���ַ���
		System.out.println(f1.getParent());
		//getParentFile()�õ���Ŀ¼��File����
		System.out.println(f1.getParentFile());
	}

}
