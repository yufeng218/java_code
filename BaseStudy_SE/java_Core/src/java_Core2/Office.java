package java_Core2;

public class Office {
	public static void main(String[] args) {
		try {
			//��ȡ�����ͣ�Ҳ�Ƕ�̬�����࣬������ʱ�̼���
			Class c = Class.forName("java_Core2.Word");
			//������Ķ���
			OfficeAble oa = (OfficeAble) c.newInstance();
			//���÷���
			oa.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}