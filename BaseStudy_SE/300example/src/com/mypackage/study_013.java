package com.mypackage;

import java.io.*;

public class study_013 {

	public static void main(String[] args) {
		try
		{
//			PrintStream output = System.out;	//保存原输出流
			PrintStream ps = new PrintStream("./log.txt");	//创建文件输出流
			System.setOut(ps);
			int age = 18;
			String sex = "女";
			System.out.println("年龄初始值为"+age);
			System.out.println("性别为"+sex);
//			System.setOut(output);				//恢复原有输出
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
