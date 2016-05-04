package org.my.test.data;

import java.util.ArrayList;

public class QuestionInfo {
	private Question question;//��ǰҳ�Ŀ�����
	private int pageIndex;//��ǰҳ
	private ArrayList<Integer> userAnswers = new ArrayList<Integer>(); //�û�ѡ��Ĵ�
	public QuestionInfo(){}
	
	public QuestionInfo(Question question, int pageIndex) {
		this.question = question;
		this.pageIndex = pageIndex;
	}

	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public ArrayList<Integer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(ArrayList<Integer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public String toString() {
		return question.toString();
	}
}
