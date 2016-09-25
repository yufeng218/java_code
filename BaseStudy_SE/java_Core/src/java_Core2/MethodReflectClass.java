package java_Core2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodReflectClass {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		UserService us = new UserService();
		
		Class c = UserService.class;
		Method mName = c.getMethod(name, new Class[]{});
		mName.invoke(us, new Object[]{});
		
	}
}

class UserService{
	public void login(){
		System.out.println("login...");
	}
	
	public void update(){
		System.out.println("update...");
	}
}