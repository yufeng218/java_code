package org.my.test.test;

import java.util.ArrayList;

import org.my.test.Exception.IdPassException;
import org.my.test.data.EntityContext;
import org.my.test.data.Question;
import org.my.test.data.QuestionInfo;
import org.my.test.data.User;
import org.my.test.service.ExamServiceImpl;

public class ExamServiceTest {
	public static void main(String[] args) {
		
		ExamServiceImpl examService = new ExamServiceImpl();
		EntityContext entityContext = new EntityContext();
		examService.setEntityContext(entityContext);
		/*try {
			
			User user = examService.logon("10001", "123456");
			System.out.println("userName:"+user.getEmail());
			
		} catch (IdPassException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		ArrayList<QuestionInfo> examQuestion = examService.getExamQuestions();
		for (QuestionInfo question : examQuestion) {
			System.out.println(question.getPageIndex()+","+question.getQuestion());
		}
	}
}
