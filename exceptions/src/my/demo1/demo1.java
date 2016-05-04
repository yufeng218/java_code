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
//	}//正确，子类抛出的异常少于父类
	
	@Override
	public void test1() throws IOException, ClassNotFoundException,
	RuntimeException
	{
		// TODO 自动生成的方法存根
		super.test1();
	}//正确，RuntimeException异常类
	
//	@Override
//	public void test1() throws IOException, ClassNotFoundException,
//	CloneNotSupportedException
//	{
//		// TODO 自动生成的方法存根
//		super.test1();
//	} //错误，trows比父类更多的异常
}

