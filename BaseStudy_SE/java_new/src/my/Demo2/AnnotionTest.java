package my.Demo2;

public class AnnotionTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		Class c = User.class;
		System.out.println(c.isAnnotationPresent(Entity.class));
		if(c.isAnnotationPresent(Entity.class)){
			//��ȡע��ʵ��
			Entity entity = (Entity)c.getAnnotation(Entity.class);
			//
			System.out.println(entity.desClass());
		}
	}

}

/*
 * ע���ʵ����
 * @ע������(������=�����ķ���ֵ)
 */
@Entity(desClass="User���ע��")
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