package com.mypackage;

import java.io.*;

public class study_013 {

	public static void main(String[] args) {
		try
		{
//			PrintStream output = System.out;	//����ԭ�����
			PrintStream ps = new PrintStream("./log.txt");	//�����ļ������
			System.setOut(ps);
			int age = 18;
			String sex = "Ů";
			System.out.println("�����ʼֵΪ"+age);
			System.out.println("�Ա�Ϊ"+sex);
//			System.setOut(output);				//�ָ�ԭ�����
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
