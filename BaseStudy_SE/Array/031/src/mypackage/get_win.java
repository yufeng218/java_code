package mypackage;

import java.util.Scanner;

public class get_win {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input_num = new Scanner(System.in);
		System.out.print("������������");
		int num = input_num.nextInt();
		//��������
		String arr[] = new String[num];
		for(int i=0;i<num;i++)
		{
			Scanner input_name = new Scanner(System.in);
			System.out.print("����������");
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
