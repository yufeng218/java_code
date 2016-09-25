package mypackage;

import java.util.Scanner;

public class get_win {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input_num = new Scanner(System.in);
		System.out.print("请输入人数：");
		int num = input_num.nextInt();
		//创建数组
		String arr[] = new String[num];
		for(int i=0;i<num;i++)
		{
			Scanner input_name = new Scanner(System.in);
			System.out.print("输入姓名：");
			arr[i] = input_name.nextLine();
		}
		printArray(arr);
		int winor = (int)(Math.random()*num);
		System.out.println("jjj:"+winor);

	}
	public static void printArray(String arr[])
	{
		for(String x:arr)
		{
			System.out.print(x+" ");
		}
	}

}
