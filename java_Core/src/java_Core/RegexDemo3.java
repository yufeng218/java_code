package java_Core;

import java.util.Scanner;

public class RegexDemo3 {

	public static void main(String[] args) {
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("�������û���������������ĸ��ͷ�����Ը����֡���ĸ���»���");
			System.out.println("(������5-10):");
			
			String regex = "^[a-zA-Z]\\w+{4,9}$";
			String name = input.nextLine();
			if(name.matches(regex)){
				System.out.println(name);
				break;
			}
			else
				System.out.println("���벻�Ϸ���");
		}
		System.out.println("^\\w+@[0-9a-zA-Z]+(\\.[a-zA-Z]+)+$");
	}

}
