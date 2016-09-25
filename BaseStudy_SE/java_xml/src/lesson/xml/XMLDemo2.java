package lesson.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析xml文件
 * @author pc
 *
 */
public class XMLDemo2 {

	public static void main(String[] args) {
		String fileName = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/user.xml";
		try {
			
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(fileName));
			//获取根节点
			Element rootElement = doc.getRootElement();
			System.out.println(rootElement.elementText("id"));
			System.out.println(rootElement.elementText("name"));
			System.out.println(rootElement.elementText("passwd"));
			System.out.println(rootElement.elementText("phone"));
			System.out.println("================================");
			
			//获取根节点下的迭代器
			Iterator<Element> elements = rootElement.elementIterator();
			while(elements.hasNext()){
				Element element = elements.next();
				Attribute attribute = element.attribute("type");
				if(attribute != null){
					System.out.println(attribute.getName()+"="+attribute.getText());
				}
				System.out.println(element.getName()+"="+element.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}

}
