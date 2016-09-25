package java_Core4.IO.Last;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Work {
	
	public static void main(String[] args) {
		
//		HashMap<String, Integer> ss = getStudents();
//		System.out.println(ss);
		
		TreeSet ts = sortStudent();
		System.out.println(ts);
	}
	
	public static HashMap<String, Integer> getStudents(){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		try {
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/java_Core4/IO/Last/info.txt")));
			String str;
			while((str = br.readLine()) != null){
				if(!str.equals("")){
					String[] lineArray = str.split(",");
					if(hm.containsKey(lineArray[1])){
						hm.put(lineArray[1], hm.get(lineArray[1])+1);
					}
					else{
						hm.put(lineArray[1], 1);
					}
				}
			}
			br.close();
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return hm;
	}
	
	static class T{
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
			return "[" + name + "_" + count + "]";
		}
		
	}
	public static TreeSet<T> sortStudent(){
		//ƒ‰√˚¿‡
		TreeSet<T> ts = new TreeSet<T>(
				new Comparator<T>() {
					@Override
					public int compare(T o1, T o2) {
						if(o1.count != o2.count)
							return o2.count - o1.count;
						return o1.name.compareTo(o2.name);
					}
				});
		
		HashMap<String, Integer> ss = getStudents();
		for (String key : ss.keySet()) {
			T t = new T(key, ss.get(key));
			ts.add(t);
		}
		return ts;
	}

}
