package lesson2;

public class Account {
	private int id;
	private int money;
	private String name;
	public Account(){}
	public Account(int id, int money, String name) {
		super();
		this.id = id;
		this.money = money;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", money=" + money + ", name=" + name + "]";
	}
	
	
}
