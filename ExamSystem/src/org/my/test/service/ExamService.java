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
	//��ȡҳ���ϵĿ�����Ϣ
	QuestionInfo getQuestionInfo(int pageIndex);
	//�����û��Ĵ�
	public ArrayList<Integer> saveUserAnswers();
	//���㿼�Ի���
	int getTotalScore();
}
