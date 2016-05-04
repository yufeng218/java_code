package java_Core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateDemo3 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getYear()+1900);
		
		//������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�����
		System.out.println(date.getTime());
	}
	
	public static Date stringToDate(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
