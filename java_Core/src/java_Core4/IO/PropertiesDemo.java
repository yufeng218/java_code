package java_Core4.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) {
		try {
			
			Properties prop = new Properties();
			//prop.load(new FileInputStream("E:\\java_IO\\aa.properties"));
			prop.load(PropertiesDemo.class.getResourceAsStream("aa.properties"));
			for(Object obj : prop.keySet()){
				String key = (String)obj;
				System.out.println(key+"="+prop.get(key));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
