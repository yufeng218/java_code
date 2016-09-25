package lesson2.orm;

@Entity("typeRe")
public class UserInfo {
	private int id;
	@TypeName(value="username")
	private String name;
	@TypeName("userage") //'value='ø…“‘ °¬‘
	private int age;
	@TypeName("userpasswd")
	private String passwd;
	
	public UserInfo(int id, String name, int age, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.passwd = passwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
