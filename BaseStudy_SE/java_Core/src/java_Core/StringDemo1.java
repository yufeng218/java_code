package java_Core;

public class StringDemo1 {

	public static void main(String[] args) {
		char[] chars = {'a','b','d','c','m'};
		String str1 = new String(chars);
		System.out.println(str1);
		
		String s1 = new String(chars,2,2);
		System.out.println(s1);
		
		String s2 = new String("helloWord��");
		System.out.println(s2);

		//����Ĺ��췽ʽ,ֱ�Ӹ�ֵ
		String s3 = "hello!"; 
		String s4 = "hello!";
		System.out.println(s3 == s4);
		/*
		 * //�ַ���������
		 * ͨ�����캯��new��һ��������µĿռ䣬ͨ��ֱ�Ӹ�ֵ�ķ�ʽ��һ�������µĿռ䣻
		 * ��ʵ��һ�����ģʽ��������Ԫģʽ 
		 */
		
		String s5 = "a"+"b"+"c"; //ֱ�ӵȼ���"abc"
	}

}
