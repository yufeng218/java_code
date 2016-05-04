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
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���?")) {
			System.exit(0);
		}
	}

	public void logon() throws IdPassException {
		String id = loginFrame.getId();
		String pass = loginFrame.getPassword();
		if (id == null || "".equals(id)) {
			throw new IdPassException("��Ų���Ϊ��!");
		}
		if (pass == null || "".equals(pass)) {
			throw new IdPassException("���벻��Ϊ��!");
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
		// ��ʾ����ҳ��
		// ׼��ҳ���ϱ�ǩ������
		if (isOver) {
			JOptionPane.showConfirmDialog(menuFrame, "���Ѿ��μ��꿼���ˣ����ܲμ���");
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
		//���Խ���ʱ��
		//final long end = System.currentTimeMillis() + examInfo.getTimerLimit() * 60 * 1000;
		final long end = System.currentTimeMillis() +  60 * 1000 / 10;
		timer = new Timer();
		//����೤ʱ����һ������
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
		// �����û�ѡ��Ĵ�
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		this.currentQuestionInfo.setUserAnswers(userAnswers);

		// ��ȡ�µ�ҳ����
		int pageIndex = currentQuestionInfo.getPageIndex() - 1;
		QuestionInfo questionInfo = this.examService.getQuestionInfo(pageIndex);
		examFrame.updateView(examInfo, questionInfo);
		this.currentQuestionInfo = questionInfo;
	}

	public void next() {
		// �����û�ѡ��Ĵ�
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		this.currentQuestionInfo.setUserAnswers(userAnswers);

		int pageIndex = currentQuestionInfo.getPageIndex() + 1;
		QuestionInfo questionInfo = this.examService.getQuestionInfo(pageIndex);
		examFrame.updateView(examInfo, questionInfo);
		this.currentQuestionInfo = questionInfo;
	}

	public void send() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(menuFrame, "��ȷ��Ҫ������?")) {
			over();
		} else {
			return;
		}
	}

	public void over() {
		isOver = true;
		timer.cancel();//����ʱ����
		// �ѵ㽻��ťʱ���ڵ�ҳ�棬��ǰ��Ĵ𰸱�������
		ArrayList<Integer> userAnswers = this.examFrame.getUserAnswers();
		// ���浱ǰ�û��Ĵ�
		this.currentQuestionInfo.setUserAnswers(userAnswers);
		totalSorce = this.examService.getTotalScore();
		JOptionPane.showConfirmDialog(examFrame, "�ܷ֣�" + totalSorce);
		examFrame.setVisible(false);
		menuFrame.setVisible(true);
	}

	public void getResult() {
		if (isOver)
			JOptionPane.showConfirmDialog(menuFrame, "�����Եĳɼ���:" + totalSorce);
		else
			JOptionPane.showConfirmDialog(menuFrame, "�����ȿ��ԣ�");
	}

	public void showRule() {
		String str = "�������飬��������!";
		JOptionPane.showConfirmDialog(menuFrame, str);
	}
}
