package lesson.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 生成xml文件
 * 
 * @author pc
 *
 */

public class XmlDemo1 {

	public static void main(String[] args) {
		Document document = DocumentHelper.createDocument();
		Element rootElement = document.addElement("alluser");
		Element idElement = rootElement.addElement("id");
		Element nameElement = rootElement.addElement("name");
		nameElement.addAttribute("type", "home");

		Element passwdElement = rootElement.addElement("passwd");
		Element phoneElement = rootElement.addElement("phone");
		Element emailElement = rootElement.addElement("email");

		idElement.setText("10001");
		nameElement.setText("zhangsan");
		passwdElement.setText("123456");
		phoneElement.setText("15211111111");
		emailElement.setText("zhangsan@163.com");

		try {
			String fileName = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/user.xml";
			// FileWriter fWriter = new FileWriter(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream(fileName), "utf-8");
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xWriter = new XMLWriter(osw, format);
			xWriter.write(document);
			xWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
