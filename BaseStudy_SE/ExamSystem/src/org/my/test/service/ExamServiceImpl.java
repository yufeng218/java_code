package org.my.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.my.test.Exception.IdPassException;
import org.my.test.data.EntityContext;
import org.my.test.data.ExamInfo;
import org.my.test.data.Question;
import org.my.test.data.QuestionInfo;
import org.my.test.data.User;
import org.my.test.util.ReadUtil;

public class ExamServiceImpl implements ExamService {
	private EntityContext entityContext;
	private ArrayList<QuestionInfo> examQuestion; //本次考试的考题

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	@Override
	public User logon(String id, String pass) throws IdPassException {
		HashMap<String, User> users = entityContext.getUsers();
		User user = users.get(id);
		if (user == null) {
			throw new IdPassException("用户不存在");
		}
		if (!users.get(id).getPass().equals(pass)) {
			throw new IdPassException("密码不正确!");
		}
		return user;
	}

	@Override
	public ExamInfo start() {
		// 获取考题
		getExamQuestions();

		ExamInfo examInfo = new ExamInfo();
		examInfo.setTitle(ReadUtil.getMessage("examtitle"));
		examInfo.setTimerLimit(Integer.parseInt(ReadUtil
				.getMessage("timerLimit")));
		examInfo.setTotalNumbers(this.examQuestion.size());

		return examInfo;
	}

	@Override
	public ArrayList<QuestionInfo> getExamQuestions() {
		int index = 0;
		// 获得题库
		HashMap<Integer, ArrayList<Question>> questions = entityContext
				.getQuestions();
		// 一次考试的考题
		examQuestion = new ArrayList<QuestionInfo>();
		for (int key = 2; key <= 5; key++) {
			// 这个等级的所有题目
			ArrayList<Question> levelQuestion = questions.get(key);
			Question question1 = levelQuestion.remove(new Random()
					.nextInt(levelQuestion.size()));
			Question question2 = levelQuestion.remove(new Random()
					.nextInt(levelQuestion.size()));

			examQuestion.add(new QuestionInfo(question1,index++));
			examQuestion.add(new QuestionInfo(question2,index++));
		}

		return examQuestion;
	}

	@Override
	public QuestionInfo getQuestionInfo(int pageIndex) {
		QuestionInfo questionInfo = this.examQuestion.get(pageIndex);
		return questionInfo;
	}

	@Override
	public ArrayList<Integer> saveUserAnswers() {
		
		return null;
	}
	
	/**
	 * 计算总分
	 */
	@Override
	public int getTotalScore() {
		int totalScore = 0;
		for(QuestionInfo questionInfo : examQuestion){
			//获取标准答案
			ArrayList<Integer> answer = questionInfo.getQuestion().getAnswers();
//			for(Integer x : answer)
//				System.out.print(x+",");
//			System.out.print("用户答案");
			//获取用户的答案
			ArrayList<Integer> userAnswer = questionInfo.getUserAnswers();
//			for(Integer x : userAnswer)
//				System.out.print(x+",");
//			System.out.println();
			if(answer.equals(userAnswer)){
				totalScore += questionInfo.getQuestion().getScore();
			}
		
		}
		return totalScore;
	}
}
