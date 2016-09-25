package java_Core3.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HasMapDemo1 {

	public static void main(String[] args) {
		User u1 = new User("001", "zhangsan", 20, "1234");
		User u2 = new User("002", "lisi", 21, "6789");
		User u3 = new User("003", "wangwu",22,"9876");
		
		HashMap hm = new HashMap();
		hm.put(u1.getId(), u1);
		hm.put(u2.getId(), u2);
		hm.put(u3.getId(), u3);
		System.out.println(hm.size());
		//ֱ�Ӵ�ӡMap������ӡ��key��toString���� = value��toString����
		System.out.println(hm);
		
		//key,value����Object; get(key)�õ�value��
		User user1 = (User)hm.get(u1.getId());
		System.out.println(user1);
		
		//�Ƿ����ĳ��key, �����Ƿ����ĳ��value
		System.out.println(hm.containsKey("003"));
		System.out.println(hm.containsKey("004"));
		
		System.out.println("========= ������ʽ ============");
		/*
		 * ������ʽ1����Map�����е�key����Set�����У�Ȼ�����Set���ϵõ�key��
		 * ͨ��key���value��
		 */
		Set set = hm.keySet();
		for(Object x : set) {
			String key = (String)x;
			User user2 = (User)hm.get(key);
			System.out.println(key + "=" + user2);
		}
		
		/*
		 * ������ʽ2������HashMap�����е�key��value��
		 * ��ʵ������װ��Map.Entry����ڲ�������ԣ�
		 * ��һ����ֵ�Ծʹ���һ��Map.Entry��ʵ������
		 * ͨ��entrySet()�����Ϳ��԰���Щʵ���������Set�����У�
		 */
		Set s1 = hm.entrySet();
		for(Object x : s1) {
			Map.Entry me = (Map.Entry)x;
			System.out.println(me.getKey() + "=" + me.getValue());
		}
		
	}

}
