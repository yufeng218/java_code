package java_Core;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDemo1 {
	public static void main(String[] args) {
		String s = "ab+defab+xyzab+ddab+nnn";
		//ʹ��ab+���ָ��ַ���
		String[] ss = s.split("ab+");
		for(String x:ss)
			System.out.println(x);
		/*
		 * ������ʽ  . * + ? ������ĺ��壬���ܵ�����ʾ���ǣ������Ҫ��ʾ����Ҫ��\ ��
		 * ����java��\���ַ�����Ҫ��\\��ʾ��
		 * �������Ͼ�Ҫ��ʾΪ��\\. \\* \\+ \\? ��
		 * ���û�м�\\�ͱ�ʾ����ĺ��壻
		 */
		System.out.println("===========");
		String[] ss2 = s.split("ab\\+");
		System.out.println(Arrays.toString(ss2));
		
		String regex = "ab\\+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		//�ж�һ���ַ����Ƿ�ƥ��һ��������ʽ
		System.out.println(matcher.matches());
		System.out.println(s.matches(regex));
		//��һ���ַ������ҵ�������ʽ��Ԫ��
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
		String regex1 = "ab\\+";
		Pattern p = Pattern.compile(regex1);
		Matcher m = p.matcher("abbbb+");
		System.out.println(m.matches());
		
	}

}
