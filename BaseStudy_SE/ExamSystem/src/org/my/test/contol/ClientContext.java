package org.my.test.contol;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.my.test.Exception.IdPassException;
import org.my.test.data.ExamInfo;
import org.my.test.data.QuestionInfo;
import org.my.test.data.User;
import org.my.test.service.ExamServiceImpl;
import org.my.test.util.ReadUtil;
import org.my.test.view.ExamFrame;
import org.my.test.view.LoginFrame;
import org.my.test.view.MenuFrame;

public class ClientContext {
	private LoginFrame loginFrame;
	private MenuFrame menuFrame;
	private ExamFrame examFrame;
	private ExamServiceImpl examService;
	private User user;
	private QuestionInfo currentQuestionInfo;
	private ExamInfo examInfo;
	private int totalSorce;
	private boolean isOver;
	private Timer timer;

	public void setExamService(ExamServiceImpl examService) {
		this.examService = examService;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	public void exit() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "确定要退出吗?")) {
			System.exit(0);
		}
	}

	public void logon() throws IdPassException {
		String id = loginFrame.getId();
		String pass = loginFrame.getPassword();
		if (id == null || "".equals(id)) {
			throw new IdPassException("编号不能为空!");
		}
		if (pass == null || "".equals(pass)) {
			throw new IdPassException("密码不能为空!");
		}
		user = examService.logon(id, pass);
		loginFrame.setVisible(false);
		menuFrame.updateMenuFrame();
		menuFrame.setVisible(true);
	}

	public User getUser() {
		return user;
	}

	public void start() {
		// 显示考试页面
		// 准备页面上标签的数据
		if (isOver) {
			JOptionPane.showConfirmDialog(menuFrame, "您已经参加完考试了，不能参加了");
			return;
		}
		examInfo = examService.start();
		this.currentQuestionInfo = examService.getQuestionInfo(0);
		examInfo.setUser(user);
		examFrame.updateView(examInfo, this.currentQuestionInfo);

		menuFrame.setVisible(false);
		examFrame.setVisible(true);
		startTime();
	}

	public void startTime() {
		//考试结束时间
		//final long end = System.currentTimeMillis() + examInfo.getTimerLimit() * 60 * 1000;
		final long end = System.currentTimeMillis() +  60 * 1000 / 10;
		timer = new Timer();
		//间隔多长时间做一次任务
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				long sub = end - System.currentTimeMillis();
				if(sub <= 0){
					over();
					return;
				}
				examFrame.updateTimer(sub);
			}
		}, 0, 1000);;
		
	}

	public void pre() {
		// 保存用户选择的答案
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		this.currentQuestionInfo.setUserAnswers(userAnswers);

		// 获取新的页数据
		int pageIndex = currentQuestionInfo.getPageIndex() - 1;
		QuestionInfo questionInfo = this.examService.getQuestionInfo(pageIndex);
		examFrame.updateView(examInfo, questionInfo);
		this.currentQuestionInfo = questionInfo;
	}

	public void next() {
		// 保存用户选择的答案
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		this.currentQuestionInfo.setUserAnswers(userAnswers);

		int pageIndex = currentQuestionInfo.getPageIndex() + 1;
		QuestionInfo questionInfo = this.examService.getQuestionInfo(pageIndex);
		examFrame.updateView(examInfo, questionInfo);
		this.currentQuestionInfo = questionInfo;
	}

	public void send() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(menuFrame, "您确定要交卷吗?")) {
			over();
		} else {
			return;
		}
	}

	public void over() {
		isOver = true;
		timer.cancel();//倒计时结束
		// 把点交卷按钮时所在的页面，当前题的答案保留下来
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		// 保存当前用户的答案
		this.currentQuestionInfo.setUserAnswers(userAnswers);
		totalSorce = this.examService.getTotalScore();
		JOptionPane.showConfirmDialog(examFrame, "总分：" + totalSorce);
		examFrame.setVisible(false);
		menuFrame.setVisible(true);
	}

	public void getResult() {
		if (isOver)
			JOptionPane.showConfirmDialog(menuFrame, "您考试的成绩是:" + totalSorce);
		else
			JOptionPane.showConfirmDialog(menuFrame, "请您先考试！");
	}

	public void showRule() {
		String str = "不允许看书，认真做题!";
		JOptionPane.showConfirmDialog(menuFrame, str);
	}
}
