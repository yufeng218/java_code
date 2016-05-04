package java_Core3.Map;

import java.util.HashMap;

public class HashMapDemo3 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("x",20);
		map.put("y",30);
		/*
		 * key��ͬ�������value�Ḳ��ǰ��ģ�
		 * key��β�����ͬ��ע��equals��hashCode������ʵ�֣�
		 */
		map.put("y", 40);
		System.out.println(map);
		
		System.out.println("=====================");
		//����ÿ���ַ����ֵĴ���
		String s = "asjgldfhhloidjrdsnaafhsdkskhdwbskdd";
		/*
		 * �õ�ĳ���ַ�����Ϊkey����HashMap�����У�
		 * ���map������key, put(key,1);
		 * ���map�д���key, put(key, value+1);
		 */
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0; i < s.length(); i++){
			String str = s.substring(i, i+1);
			if(hm.containsKey(str)) {
				hm.put(str, hm.get(str)+1);
			} else {
				hm.put(str, 1);
			}
		}
		System.out.println(hm);
		
	}

}
