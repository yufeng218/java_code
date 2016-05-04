package org.my.test.util;

import java.util.Properties;

public class ReadUtil {
	
	private static Properties prop = new Properties();
	
	static{
		try {
			prop.load(ReadUtil.class.getResourceAsStream("/data.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMessage(String propName){
		return prop.getProperty(propName);
	}
}
