package lesson.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EntityContext {

	// ����û���Ϣ
	private HashMap<String, User> users = new HashMap<String, User>();
	/*
	 * ������ģ����е����Եȼ�Ϊkey��ArrayListΪvalue��
	 * ArrayList�д��ͬһ���ȼ�����Ŀ
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
	 * ����Ŀ�еĵȼ���Ϊkey����Ŀ�ļ�����Ϊvalue����map
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
	 * ����һ����Ŀ����װ��Question����
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
	 * �������е�ѡ��
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
	 * ������Ŀ�Ĵ�
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
	 * �������
	 * @return
	 */
	public HashMap<Integer, ArrayList<Question>> getQuestions() {
		return questions;
	}
	/**
	 * �����û�
	 * @return
	 */
	public HashMap<String, User> getUsers() {
		return users;
	}
	
	
}
