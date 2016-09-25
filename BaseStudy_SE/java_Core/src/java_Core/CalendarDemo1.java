package java_Core;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {

	public static void main(String[] args) {
		//test1();
		//test2();
		test3();
	}
	
	public static void test1(){
		//Calendar 的 getInstance 方法返回一个 Calendar 对象，其日历字段已由当前日期和时间初始化
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
	}
	
	public static void test2(){
		String s = "1998-10-10";
		Date date = DateDemo3.stringToDate(s);
		System.out.println(date);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		System.out.println(c.get(Calendar.YEAR));
	}
	
	//输入雇佣日期、获取转正日期
	private static void test3(){
		String s = "1989-11-09";
		Date date = DateDemo3.stringToDate(s);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 3);
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH)+1;
		int d = c.get(Calendar.DATE);
		System.out.printf("转正日期是：%d-%d-%d",y,m,d);
	}

}
