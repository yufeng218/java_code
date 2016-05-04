package java_Core3.Map;

public class User1 implements Comparable<User1> {
	private String id;
	private String name;
	private int age;
	private String pass;
	public User1(){}
	public User1(String id, String name, int age, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "[" + id + "," + name + "]";
	}
	@Override
	public int compareTo(User1 o) {
		if(!this.id.equals(o.id))
			return this.id.compareTo(o.id);
		return 0;
	}

}
