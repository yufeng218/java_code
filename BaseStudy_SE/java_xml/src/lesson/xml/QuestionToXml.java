package lesson.xml;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import lesson.util.EntityContext;
import lesson.util.Question;

public class QuestionToXml {

	public static void main(String[] args) {
		builderQuestionToXml();
	}
	
	public static void builderQuestionToXml(){
		EntityContext entityContext = new EntityContext();
		HashMap<Integer, ArrayList<Question>> questionInfo = 
				entityContext.getQuestions();
		Document doc = DocumentHelper.createDocument();
		Element rootElement = doc.addElement("allquestions");
		String filePath = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/questions.xml";
		int num = 0;
		for (Integer key : questionInfo.keySet()) {
			ArrayList<Question> quetions = questionInfo.get(key);
			
			Iterator<Question> iterator = quetions.iterator();
			while(iterator.hasNext()){
				num++;
				Question question = iterator.next();
				Element element = rootElement.addElement("question");
				element.addAttribute("id", num+"");
				Element titleElement = element.addElement("title");
				titleElement.setText(question.getTitle());
				
				Element optionsElement = element.addElement("options");
				ArrayList<String> options = question.getOptions();
				for (String option : options) {
					Element optionElement = optionsElement.addElement("option");
					optionElement.setText(option);
				}
				
				Element answersElement = element.addElement("answers");
				ArrayList<Integer> answers = question.getAnswers();
				for (Integer answer : answers) {
					Element answerElement = answersElement.addElement("answer");
					answerElement.setText(Integer.toString(answer));
				}
				
				Element scoreElement = element.addElement("score");
				scoreElement.setText(Integer.toString(question.getScore()));
				Element levelElement = element.addElement("level");
				levelElement.setText(Integer.toString(question.getLevel()));
			}
		}
		printToxml(filePath, doc);
	}
	
	public static void printToxml(String filePath, Document doc){
		try {
			
			FileWriter osw = new FileWriter(filePath);
//			OutputStreamWriter osw = new OutputStreamWriter(
//					new FileOutputStream(filePath), "utf-8");
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(osw, outputFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
