package lesson.xml;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import lesson.util.Question;

public class ImportQuestionToTable {

	public static void main(String[] args) {
		
		toDB();
	}
	
	/**
	 * 读取xml文件
	 * @return
	 */
	public static ArrayList<Question> parseQuestionXml(){
		String filePath = "E:/git_project/java_code/woYing/java_xml/src/lesson/xml/questions.xml";
		ArrayList<Question> questions = new ArrayList<Question>();
		SAXReader reader = new SAXReader();
		try {
			
			Document doc = reader.read(new File(filePath));
			Element rootElement = doc.getRootElement();
			//获取根节点的元素
			Iterator<Element> iterator = rootElement.elementIterator();
			while(iterator.hasNext()){
				Question question = new Question();
				Element questionElement = iterator.next();
				Attribute attribute = questionElement.attribute("id");
				question.setId(Integer.parseInt(attribute.getValue()));
				question.setTitle(questionElement.elementText("title"));
				question.setScore(Integer.parseInt(questionElement.elementText("score")));
				question.setLevel(Integer.parseInt(questionElement.elementText("level")));
				
				//options的获取
				ArrayList<String> options = new ArrayList<String>();
				Element optionsElement = questionElement.element("options");
				Iterator<Element> optionsItor = optionsElement.elementIterator();
				while(optionsItor.hasNext()){
					String string = optionsItor.next().getText();
					options.add(string);
				}
				question.setOptions(options);
				
				//answers的获取
				ArrayList<Integer> answers = new ArrayList<Integer>();
				Element answersElement = questionElement.element("answers");
				Iterator<Element> answersItor = answersElement.elementIterator();
				while(answersItor.hasNext()){
					answers.add(Integer.parseInt(answersItor.next().getText()));
				}
				question.setAnswers(answers);
				questions.add(question);
			}
			return questions;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 数据存储到数据库
	 */
	public static void toDB(){
		ArrayList<Question> questions = parseQuestionXml();
		Connection connection = JdbcUtil.getConn();
		PreparedStatement pstmt = null;
		String sql = "insert into questions(id,title,options,answer,score,qlevel)"
				+ "values (?,?,?,?,?,?)";
		try {
			
			pstmt = connection.prepareStatement(sql);
			for (Question question : questions) {
				pstmt.setInt(1, question.getId());
				pstmt.setString(2, question.getTitle());
				
				String options = "";
				ArrayList<String> optionsList = question.getOptions();
				for (String string : optionsList) {
					options += string + "|";
				}
				pstmt.setString(3, options);
				
				String answers = "";
				ArrayList<String> answersList = question.getOptions();
				for (String string : answersList) {
					answers += string + "|";
				}
				pstmt.setString(4, answers);
				
				pstmt.setInt(5, question.getScore());
				pstmt.setInt(6, question.getLevel());
				
				//运行sql语句
				int n = pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt, null);
			JdbcUtil.closeConnection();
		}
	}
	
	
	
}
