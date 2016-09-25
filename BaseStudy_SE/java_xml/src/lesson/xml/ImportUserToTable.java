package lesson.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ImportUserToTable {

	public static void main(String[] args) {
		
		parseUserXml();
		
	}
	
	public static void parseUserXml(){
		String filePath = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/users.xml";
		
		SAXReader reader = new SAXReader();
		try {
			
			Document doc = reader.read(new File(filePath));
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
