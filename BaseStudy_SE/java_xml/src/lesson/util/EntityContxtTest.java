package lesson.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EntityContxtTest {

	public static void main(String[] args) {
		
		EntityContext entity = new EntityContext();
		/*
		HashMap<String, User> users = entity.getUsers();
		
		for(String x : users.keySet()){
			System.out.println(users.get(x));
		}
		*/
		HashMap<Integer, ArrayList<Question>> questions = entity.getQuestions();
		
		for(Integer key : questions.keySet()){
			System.out.println(key);
			ArrayList<Question> levelQuestion = questions.get(key);
			for(Question x : levelQuestion){
				System.out.println(x);
			}
			System.out.println("=============================");
		}
		
		
	}

}
