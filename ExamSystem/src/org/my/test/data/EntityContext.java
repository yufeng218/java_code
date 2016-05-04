package org.my.test.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.my.test.util.IOUtil;
import org.my.test.util.ReadUtil;

public class EntityContext {

	// 存放用户信息
	private HashMap<String, User> users = new HashMap<String, User>();
	/*
	 * 存放题库的，所有的题以等级为key，ArrayList为value；
	 * ArrayList中存放同一个等级的题目
	*/
	private HashMap<Integer, ArrayList<Question>> questions = new HashMap<Integer, ArrayList<Question>>();

	public EntityContext() {
		try {
			loadUser();
			loadQuestion();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadUser() throws IOException {
		BufferedReader br = IOUtil.getReader(ReadUtil.getMessage("userpath"));
		String str = null;
		while ((str = br.readLine()) != null) {
			if (str.startsWith("#"))
				continue;
			String[] userMessage = str.split(":");
			User user = new User(userMessage[0], userMessage[1],
					userMessage[2], userMessage[3]);
			users.put(user.getId(), user);
		}
		IOUtil.close();
	}
	
	
	private void loadQuestion() throws IOException{
		BufferedReader br = IOUtil.getReader(ReadUtil.getMessage("questionpath"));
		String row = null;
		while((row = br.readLine()) != null){
			Question question = parseQuestion(br, row);
			putQuestion(question);
		}
	}
	
	/**
	 * 把题目中的等级作为key，题目的集合作为value放入map
	 * @param question
	 */
	private void putQuestion(Question question){
		int level = question.getLevel();
		if(questions.containsKey(level)){
			questions.get(level).add(question);
		} else {
			ArrayList<Question> levelQuestion = new ArrayList<Question>();
			levelQuestion.add(question);
			questions.put(level,levelQuestion);
		}
	}
	/**
	 * 解析一个题目并封装成Question对象
	 * @param br
	 * @param row
	 * @return
	 * @throws IOException
	 */
	private Question parseQuestion(BufferedReader br, String row) throws IOException {
		Question question = new Question();
		String regex = "[@,][a-z]+=";
		String[] ss = row.split(regex);
		question.setScore(Integer.parseInt(ss[2]));
		question.setLevel(Integer.parseInt(ss[3]));
		question.setAnswers(getAnswers(ss[1]));
		String title = br.readLine();
		question.setTitle(title);
		question.setOptions(getOptions(br));
		return question;
	}
	/**
	 * 解析题中的选项
	 * @param br
	 * @return
	 * @throws IOException
	 */
	private ArrayList<String> getOptions(BufferedReader br) throws IOException{
		ArrayList<String> option = new ArrayList<String>();
		for(int i = 0; i < 4; i++){
			option.add(br.readLine());
		}
		return option;
	}
	/**
	 * 解析题目的答案
	 * @param ans
	 * @return
	 */
	private ArrayList<Integer> getAnswers(String ans){
		String[] answers = ans.split("/");
		ArrayList<Integer> as = new ArrayList<Integer>();
		for(String x : answers){
			as.add(Integer.parseInt(x));
		}
		return as;
	}
	/**
	 * 返回题库
	 * @return
	 */
	public HashMap<Integer, ArrayList<Question>> getQuestions() {
		return questions;
	}
	/**
	 * 返回用户
	 * @return
	 */
	public HashMap<String, User> getUsers() {
		return users;
	}
	
	
}
