package java_Core4.IO;

import java.io.UnsupportedEncodingException;


public class EncodeDemo1 {
	public static void main(String[] args) {
		//java�����ڲ�һ���ַ�ռ��2���ֽڣ����������Ļ���Ӣ��
		String s = "ABC��";
		byte[] b = s.getBytes();//Ĭ�ϻ�����Ŀ�ı������ת��
		for (byte c : b) {
			System.out.print(Integer.toHexString(c & 0xff) + " ");
		}
		
		System.out.println("=====================");
		try {
			byte[] b1 = s.getBytes("gbk");
			System.out.println(b1.length);
			for (byte c : b1) {
				System.out.print(Integer.toHexString(c&0xFF) + " ");
			}//gbk����1��Ӣ��ռ��һ���ֽڣ�һ������ռ��2���ֽڣ�

			System.out.println("======================");
			byte[] b2 = s.getBytes("utf-8");
			System.out.println(b2.length);
			for (byte c : b2) {
				System.out.print(Integer.toHexString(c & 0xFF) + " ");
			}
		
			System.out.println("=======================");
			byte[] b3 = s.getBytes("utf-16be");
			System.out.println(b3.length);
			for (byte c : b3) {
				System.out.print(Integer.toHexString(c&0xFF) + " ");
			}
			
			System.out.println("====================");
			String s1 = new String(b1, "gbk");
			System.out.println(s1);
			
			String s2 = new String(b2, "gbk");//b2��utf-8��������
			System.out.println(s2);
			String s3 = new String(b2, "utf-8");//b2��utf-8��������
			System.out.println(s3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
