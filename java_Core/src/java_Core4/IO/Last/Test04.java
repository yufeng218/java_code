package java_Core4.IO.Last;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test04 {
	// ����ջ�Ľṹ����ַ�����������ʾ����Сдת��
	// ת����Сд
	public char toggle_case(char c) {
		if (c <= 'z' && c >= 'a') {
			c = (char) (c - 32);
			return c;
		}
		if (c <= 'Z' && c >= 'A') {
			c = (char) (c + 32);
			return c;
		}
		return c;
	}
	public void reverse_play_and_toggle_case(String sData) {
		char[] tempData = sData.toCharArray();
		Stack savesStack = new Stack(sData.length());
		// ��ջ���
		System.out.println("��ջ�ַ���");
		int count = 0;
		while (!savesStack.isFull()) {
			System.out.println(tempData[count]);
			savesStack.push(tempData[count]);
			count++;
		}
		// ��ջ����Сдת�����
		System.out.println("��ջ�ַ���");
		while (!savesStack.isEmpty()) {
			System.out.println(toggle_case(savesStack.pop()));
		}
	}
	public static void main(String args[]) throws IOException {
		File file = new File("d:" + File.separator + "tt.txt");
		Reader reader = new FileReader(file);
		char[] data = new char[(int) file.length()];
		reader.read(data);
		reader.close();
		String s = data.toString();
		Test04 test1 = new Test04();
		test1.reverse_play_and_toggle_case(s);
	}
}
// ����˳��ջ
class Stack {
	private char[] stackArray;
	private int top;
	private int maxSize;
	Stack(int size) {
		this.maxSize = size;
		top = -1;
		stackArray = new char[size];
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	public void push(char data) {
		stackArray[++top] = data;
	}
	public char pop() {
		char temp = stackArray[top--];
		return temp;
	}
}

