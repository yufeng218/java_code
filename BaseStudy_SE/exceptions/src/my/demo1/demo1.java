package my.demo1;

import java.io.IOException;


public class demo1 
{
	   public static int div(int a,int b) throws Exception{
		   int result=a/b;
		   return result;
	   }
	   public static void main(String[] args) throws Exception {
	      int result =div(8,0);
	      System.out.println(result);
	   }
}

class A
{
	public void test1()throws IOException,ClassNotFoundException
	{
		
	}
}

class B extends A 
{
//	@Override
//	public void test1() throws IOException {
//		
//	}//��ȷ�������׳����쳣���ڸ���
	
	@Override
	public void test1() throws IOException, ClassNotFoundException,
	RuntimeException
	{
		// TODO �Զ����ɵķ������
		super.test1();
	}//��ȷ��RuntimeException�쳣��
	
//	@Override
//	public void test1() throws IOException, ClassNotFoundException,
//	CloneNotSupportedException
//	{
//		// TODO �Զ����ɵķ������
//		super.test1();
//	} //����trows�ȸ��������쳣
}

