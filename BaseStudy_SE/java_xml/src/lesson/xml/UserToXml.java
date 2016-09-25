package lesson.xml;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import lesson.util.EntityContext;
import lesson.util.User;

public class UserToXml {

	public static void main(String[] args) {
		
		builderUserToXml();

	}
	
	public static void builderUserToXml(){
		EntityContext entityContext = new EntityContext();
		HashMap<String, User> users = entityContext.getUsers();
		
		Document doc = DocumentHelper.createDocument();
		Element rootElement = doc.addElement("allusers");
		String filePath = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/users.xml";
		
		for (String key : users.keySet()) {
			User user = users.get(key);
			Element element = rootElement.addElement("user");
			Element idElement = element.addElement("id");
			idElement.setText(user.getId());
			Element nameElement = element.addElement("name");
			nameElement.setText(user.getName());
			Element passElement = element.addElement("pass");
			passElement.setText(user.getPass());
			Element emailElement = element.addElement("email");
			emailElement.setText(user.getEmail());
		}
		printToxml(filePath, doc);
	}
	
	public static void printToxml(String filePath, Document doc){
		try {
			
//			FileWriter fWriter = new FileWriter(filePath);
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream(filePath), "utf-8");
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(osw, outputFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
