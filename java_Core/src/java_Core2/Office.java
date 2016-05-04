package java_Core2;

public class Office {
	public static void main(String[] args) {
		try {
			//获取类类型，也是动态加载类，在运行时刻加载
			Class c = Class.forName("java_Core2.Word");
			//创建类的对象
			OfficeAble oa = (OfficeAble) c.newInstance();
			//调用方法
			oa.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
