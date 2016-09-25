package java_Core3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {
	public static void main(String[] args) {
		HashSet<student> list = new HashSet<student>();
		student stu1 = new student("001","zhangsan",22);
		student stu2 = new student("002","lisi",23);
		student stu3 = new student("003","wangwu",24);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println("=======================");
		for(student s : list){
			System.out.println(s);
		}
		
		System.out.println("======================");
		
		Iterator<student> itor = list.iterator();
		while(itor.hasNext()){
			System.out.println(itor.next());
		}
		
		System.out.println("=======================");
		//HashSet.add():�����ظ���Ԫ�ػᱻ�Զ����ˣ�
		student stu4 = new student("003","wangwu",24);
		list.add(stu4);
		System.out.println(list);
		/*
		 * �ظ�Ԫ�صĶ���;
		 * ����������б�����Ψһ��ʶ�������������д;
		 * equals��hashCode����
		 * hashCode������һ��ɢ���㷨�����ڲ��ù������ȥд��
		 * ����HashSet�����ݵĴ����ֱ�ӹ�ϵ;
		 * 
		 */
		
		
		
	}

}
