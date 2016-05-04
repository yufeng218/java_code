package java_Core2;

import java.lang.reflect.Constructor;
public class ConstructorReflectDemo1 {

	public static void main(String[] args) {
		try {
			Class c = student.class;
			Constructor con = c.getConstructor(new Class[]{});
			student stu = (student)con.newInstance(new Object[]{});
			stu.getAge();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class student{
	private String name;
	private int age;
	public student(){}
	public student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}