package org.my.test.data;

public class ExamInfo {
	private User user;//考试的用户信息
	private int timerLimit;//时间限制
	private String title;//考试科目
	private int totalNumbers;//考试的题量
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
		String text = String.format("姓名:%s  编号:%s  考试时间:%s分钟   科目:%s  考试题量:%s", 
				user.getName(), user.getId(), timerLimit, title, totalNumbers);
		
		return text;
	}
}
