package java_Core3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo2 {
	public static void main(String[] args) {
		HashSet<student> list = new HashSet<student>();
		student stu1 = new student("001","zhangsan",22);
		student stu2 = new student("002","lisi",23);
		student stu3 = new student("003","wangwu",24);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println(list.size());
		
		/*
		 * HashSet���Ԫ�ص�λ���ǺͶ���hashCode�㷨�õ���ֵ��صġ�
		 * ��ô����Ԫ��ʱ��ҲҪ��������㷨��ֵ�ҵ����λ�ã�Ȼ���Ƴ�Ԫ�أ�
		 * ���û�и�Ԫ�ش��ڣ�remove()��������false��
		 * ��������㷨��ص�����ֵ�ڷ����������޸��ˣ�
		 * ��ζ��hashCode�㷨�õ���ֵ��֮ǰ��������ʱ��һ���ˣ��Ҷ����λ�þͷ����˸ı䣬
		 * �Ӷ��Ҳ������󣬵���Ԫ�ز��ܱ��Ƴ����ö���֮��������ڴ�й©��
		 */
		
		stu1.setNo("000");//�޸�stu1����󣬶������Ƴ�
		
		//ɾ��stu1
		list.remove(stu1);
		System.out.println(list.size());
		
	}
}
