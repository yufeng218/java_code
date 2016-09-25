package my.demo1;

public class demo2 {

	public static void main(String[] args) 
	{
		PersonB pb = new PersonB();
//		try 
//		{
//			pb.setAge(100);
//		} 
//		catch (AgeException e) 
//		{
//			//e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		
		try 
		{
			pb.setName("afslfalfefldfdsfa");
		} catch (NameException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}

}

class PersonB
{
	private int age;
	private String name;

	public void setAge(int age) throws AgeException
	{
		if(age<0 || age>80)
			throw new AgeException("ÄêÁä³¬³ö·¶Î§£¡");
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
	
	
	public void setName(String name) throws NameException{
		if(name.length()<5||name.length()>10)
			throw new NameException("ÐÕÃû³¤¶È³¬³ö·¶Î§£¡");
		this.name = name;
	}
	
	
}
