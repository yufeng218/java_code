package mypackage;

public class Demo1 {

	public static void main(String[] args) {
		student s1 = new student(001,"xiaoli",26,"class1");
		student s2 = new student(001,"xiaoli",26,"class1");
		//student s2 = new student(002,"lisi",25,"class1");
		//s1.setAge(25);
		System.out.println(s1.equals(s2));
	}

}
