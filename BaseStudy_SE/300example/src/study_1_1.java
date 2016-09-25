/*
 * 输出控制台传递的参数；
 * （1）打开cmd窗口，进入存放study_1_1.java文件的代码目录；
 * （2）运行：javac study_1_1.java 会生成study_1_1.class文件；
 * （3）运行：java study_1_1 How are you 
 * （4）结果：How
 * 			 are
 * 			 you
 */

public class study_1_1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}

}
