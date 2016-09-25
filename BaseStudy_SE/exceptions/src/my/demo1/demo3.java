package my.demo1;

public class demo3 {

	public static void main(String[] args) {
		
	}
	public static int doSomeThing(int age)
	{
		
		int RuAge=0;
		try
		{
			PersonB pb = new PersonB();
			pb.setAge(1000);
			RuAge = pb.getAge();
		}
		catch (AgeException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			return RuAge;
		}
	}
}
