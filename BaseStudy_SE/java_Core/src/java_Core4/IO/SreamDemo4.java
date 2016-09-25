package java_Core4.IO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SreamDemo4 {

	public static void main(String[] args) {
		
		write();
		read();
	}
	public static void write(){
		
		try {
			/*
			//��1.txt�ļ���Ϊ�ֽ������������ֱ�ӿ���дjava���������ͣ�
			DataOutputStream out = new DataOutputStream(
					new FileOutputStream("D:\\1.txt"));
			*/
			
			/*
			//��1.txt�ļ���Ϊ�ֽ�������������ȷ��뻺����������ֱ�ӿ���дjava��������
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("D:\\1.txt")));
			*/
			//�������⹦�ܵ����඼���ɻ�������Ƕ�׹����������ʵ����װ��ģʽ��
			//���磺BufferedOutputStream(FileOutputStream out);
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("E:\\java_IO\\a.txt")));
			out.writeInt(1000);
			out.writeBoolean(true);
			out.writeDouble(10.23);
			out.writeUTF("��lll");
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void read(){
			try {
				
				DataInputStream in = new DataInputStream(
						new FileInputStream("E:\\java_IO\\a.txt"));
				
				System.out.println(in.readInt());
				System.out.println(in.readBoolean());
				System.out.println(in.readDouble());
				System.out.println(in.readUTF());
				in.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
