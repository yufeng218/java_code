package org.my.test.service;

import java.util.ArrayList;

import org.my.test.Exception.IdPassException;
import org.my.test.data.ExamInfo;
import org.my.test.data.Question;
import org.my.test.data.QuestionInfo;
import org.my.test.data.User;

public interface ExamService {
	User logon(String id, String pass) throws IdPassException;
	ExamInfo start();
	ArrayList<QuestionInfo> getExamQuestions();
	//获取页面上的考试信息
	QuestionInfo getQuestionInfo(int pageIndex);
	//保存用户的答案
	public ArrayList<Integer> saveUserAnswers();
	//计算考试积分
	int getTotalScore();
}
