/*
 * 接收控制台的输入字符
 */
import java.util.*;

public class study_011 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input = new Scanner(System.in);
		System.out.print("请输入您的身份证号：");
		String id = input.nextLine();
		System.out.println(id);
		System.out.printf("你的身份证是%d位",id.length());
	}

}
