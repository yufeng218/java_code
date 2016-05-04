package org.my.test.data;

import java.util.ArrayList;

public class Question {
	private int id;//编号
	private String title;//提干
	private int score;//分数
	private int level;//等级
	private ArrayList<Integer> answers;//标准答案
	private ArrayList<String> options;//选项
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<Integer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Integer> answers) {
		this.answers = answers;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(title).append("\n");
		char a = 'A';
		for(String option : options){
			s.append((char)a++).append(".").append(option).append("\n");
		}
		return s.toString();
	}
}
