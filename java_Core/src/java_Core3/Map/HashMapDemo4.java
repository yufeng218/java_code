package java_Core3.Map;

import java.util.HashMap;
import java.util.Set;

import java.util.TreeSet;
import java.lang.Comparable;

public class HashMapDemo4 {
	public static void main(String[] args) {
		/*
		 * 计算每个字符出现的次数,输出时按照次数降序排序；
		 * 如果次数相同,按照字母升序排序;
		 * 
		 * 思路：通过HashMap集合来实现计数操作，
		 * 	         通过TreeSet集合来进行排序；
		 *   TreeSet排序是按照它里面的对象的属性来排序的；
		 *   我们可以抽取一个类进行排序；
		 */
		
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
		
		/*
		 * 遍历HashMap集合，然后把每一个key/value都包装成T对象的实例放入TreeSet集合，
		 * 这样就完成了排序；
		 */
		TreeSet<T> trees = new TreeSet<T>();
		Set<String> set = hm.keySet();
		for(String obj : set) {
			//T t = new T(obj, hm.get(obj));
			trees.add(new T(obj, hm.get(obj)));
		}
		System.out.println(trees);
	}
}

class T implements Comparable<T>{
	private String name;
	private int count;
	
	public T(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return name + "出现的次数是:" + count;
	}
	@Override
	public int compareTo(T o) {
		if(this.count != o.count) {
			return o.count - this.count;
		}
		return this.name.compareTo(o.name);
	}
	
	
}







