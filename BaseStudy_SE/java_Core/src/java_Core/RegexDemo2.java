package java_Core;


import java.util.regex.*;
import java.util.Arrays;

public class RegexDemo2 {

	public static void main(String[] args) {
		String s = "abc123def456sig5677xx";
		//找出其中的数字
		
		String regex = "\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		int sum = 0;
		while(m.find()){
			//System.out.println(m.group());
			sum += Integer.parseInt(m.group());
		}
		System.out.println(sum);
		
		System.out.println("=============");
		sum = 0;
		regex = "\\D+";
		String[] ss = s.split(regex);
		for(String x : ss){
			if(!x.equals(""))
				sum += Integer.parseInt(x);
		}
		System.out.println(sum);
	}

}
