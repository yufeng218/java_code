package java_Core;

import java.util.Scanner;

public class RegexDemo3 {

	public static void main(String[] args) {
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("请输入用户名，必须是以字母开头，可以跟数字、字母、下划线");
			System.out.println("(长度是5-10):");
			
			String regex = "^[a-zA-Z]\\w+{4,9}$";
			String name = input.nextLine();
			if(name.matches(regex)){
				System.out.println(name);
				break;
			}
			else
				System.out.println("输入不合法！");
		}
		System.out.println("^\\w+@[0-9a-zA-Z]+(\\.[a-zA-Z]+)+$");
	}

}
