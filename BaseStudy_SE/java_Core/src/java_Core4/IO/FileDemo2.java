package java_Core4.IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo2 {

	public static void main(String[] args) {
//		System.out.println(File.separator + "tt");
//		System.out.println(File.separatorChar + "tt");

		File f = new File("E:\\java_exam\\woYing");
		//listFile1(f);
		//listFile2(f);
		//listFile3(f);
		listFile4(f);
	}
	
	public static void listFile(File file){
		/*String[] filenames = file.list();
		for (String string : filenames) {
			System.out.print(string + " ");
		}*/
		
		File[] fs = file.listFiles();
		for (File file2 : fs) {
			System.out.println(file2);
			System.out.println(file2.getAbsolutePath());
		}
	}
	public static void listFile1(File file){
		/**
		 * �ܹ�����file��file��Ŀ¼�µ������ļ���·��
		 * @param file
		 */
		File[] fs = file.listFiles();
		for (File file2 : fs) {
			if(file2.isDirectory()){
				listFile1(file2);
			}
			if(file2.isFile()){
				System.out.println(file2.getAbsolutePath());
			}
			
		}
		
	}
	public static void listFile2(File file) {
		String[] fileNames = file.list(new myFileNameFilter());
		for (String string : fileNames) {
			System.out.println(string);
		}
	}
	static class myFileNameFilter implements FilenameFilter {
		//file�г���ÿ���ļ���Ҫ����accept����������true�����£�����false������
		@Override
		public boolean accept(File dir, String name) {
			System.out.println(dir.getAbsolutePath() + "..." + name);
//			return true;
			return !name.endsWith(".java");
		}
	}
	public static void listFile3(File file) 
	{
		File[] files = file.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				System.out.println(pathname);
				//pathname����file�µ��ļ���Ŀ¼
				return true;
			}
		});
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
	public static void listFile4(File file)
	{
		/*
		 * �ݹ��ó�.java�ļ���������Ŀ¼����ģ�
		 */
		File[] files = file.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) 
			{
				if(pathname.isFile())
					return pathname.getAbsolutePath().endsWith(".java");
				else
					listFile4(pathname);
				return true;
			}
		});
		for (File file2 : files) {
			if(file2.isFile())
				System.out.println(file2.getAbsolutePath());
		}
	}
}
