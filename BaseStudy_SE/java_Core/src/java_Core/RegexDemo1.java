package java_Core;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDemo1 {
	public static void main(String[] args) {
		String s = "ab+defab+xyzab+ddab+nnn";
		//使用ab+来分割字符串
		String[] ss = s.split("ab+");
		for(String x:ss)
			System.out.println(x);
		/*
		 * 正则表达式  . * + ? 有特殊的含义，不能单独表示他们，如果非要表示就需要用\ ；
		 * 而在java中\在字符串中要用\\表示；
		 * 所以以上就要表示为：\\. \\* \\+ \\? ；
		 * 如果没有加\\就表示特殊的含义；
		 */
		System.out.println("===========");
		String[] ss2 = s.split("ab\\+");
		System.out.println(Arrays.toString(ss2));
		
		String regex = "ab\\+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		//判断一个字符串是否匹配一个正则表达式
		System.out.println(matcher.matches());
		System.out.println(s.matches(regex));
		//在一个字符串中找到正则表达式的元素
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
		String regex1 = "ab\\+";
		Pattern p = Pattern.compile(regex1);
		Matcher m = p.matcher("abbbb+");
		System.out.println(m.matches());
		
	}

}
