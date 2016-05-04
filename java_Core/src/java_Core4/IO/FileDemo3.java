package java_Core4.IO;

import java.io.File;
import java.io.FileFilter;

public class FileDemo3 {

	public static void main(String[] args) {
		
		File file = new File("F:\\ksafe");
		deleteFile2(file);
	}
	
	public static void deleteFile(File file)
	{
		File[] fs = file.listFiles();
		for (File file2 : fs) {
			if(file2.isFile()){
				System.out.println(file2.getAbsolutePath());
				file2.delete();
			} else if (file2.isDirectory()){
				deleteFile(file2);
			}
		}
		System.out.println(file.getAbsolutePath());
		file.delete();
	}

	
	public static void deleteFile2(File file){
		File[] fs = file.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				if(pathname.isFile()){
					System.out.println(pathname.getAbsolutePath());
					pathname.delete();
				} else if(pathname.isDirectory()){
					deleteFile2(pathname);
				}
				return true;
			}
		});
		
		System.out.println(file.getAbsolutePath());
		file.delete();
	}
}
