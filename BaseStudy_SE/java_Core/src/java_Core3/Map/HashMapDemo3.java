package java_Core3.Map;

import java.util.HashMap;

public class HashMapDemo3 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("x",20);
		map.put("y",30);
		/*
		 * key相同，后面的value会覆盖前面的；
		 * key如何才能相同，注意equals和hashCode方法的实现；
		 */
		map.put("y", 40);
		System.out.println(map);
		
		System.out.println("=====================");
		//计算每个字符出现的次数
		String s = "asjgldfhhloidjrdsnaafhsdkskhdwbskdd";
		/*
		 * 拿到某个字符，作为key放入HashMap集合中；
		 * 如果map不存在key, put(key,1);
		 * 如果map中存在key, put(key, value+1);
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
