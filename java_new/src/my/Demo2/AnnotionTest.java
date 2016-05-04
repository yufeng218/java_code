package my.Demo2;

public class AnnotionTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Class c = User.class;
		System.out.println(c.isAnnotationPresent(Entity.class));
		if(c.isAnnotationPresent(Entity.class)){
			//获取注解实例
			Entity entity = (Entity)c.getAnnotation(Entity.class);
			//
			System.out.println(entity.desClass());
		}
	}

}

/*
 * 注解的实例化
 * @注解类名(方法名=方法的返回值)
 */
@Entity(desClass="User类的注解")
class User{
	private String name;
	private int age;
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