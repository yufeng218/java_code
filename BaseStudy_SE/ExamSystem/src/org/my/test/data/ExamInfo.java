package org.my.test.data;

public class ExamInfo {
	private User user;//���Ե��û���Ϣ
	private int timerLimit;//ʱ������
	private String title;//���Կ�Ŀ
	private int totalNumbers;//���Ե�����
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTimerLimit() {
		return timerLimit;
	}
	public void setTimerLimit(int timerLimit) {
		this.timerLimit = timerLimit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalNumbers() {
		return totalNumbers;
	}
	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}
	@Override
	public String toString() {
		String text = String.format("����:%s  ���:%s  ����ʱ��:%s����   ��Ŀ:%s  ��������:%s", 
				user.getName(), user.getId(), timerLimit, title, totalNumbers);
		
		return text;
	}
}
