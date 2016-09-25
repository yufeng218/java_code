package java_Core3.Map;

import java.util.HashMap;
import java.util.Set;

import java.util.TreeSet;
import java.lang.Comparable;

public class HashMapDemo4 {
	public static void main(String[] args) {
		/*
		 * ����ÿ���ַ����ֵĴ���,���ʱ���մ�����������
		 * ���������ͬ,������ĸ��������;
		 * 
		 * ˼·��ͨ��HashMap������ʵ�ּ���������
		 * 	         ͨ��TreeSet��������������
		 *   TreeSet�����ǰ���������Ķ��������������ģ�
		 *   ���ǿ��Գ�ȡһ�����������
		 */
		
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
		
		/*
		 * ����HashMap���ϣ�Ȼ���ÿһ��key/value����װ��T�����ʵ������TreeSet���ϣ�
		 * ���������������
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
		return name + "���ֵĴ�����:" + count;
	}
	@Override
	public int compareTo(T o) {
		if(this.count != o.count) {
			return o.count - this.count;
		}
		return this.name.compareTo(o.name);
	}
	
	
}







