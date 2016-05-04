package org.my.test.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.my.test.contol.ClientContext;
import org.my.test.data.ExamInfo;
import org.my.test.data.QuestionInfo;
import org.my.test.util.ReadUtil;

public class ExamFrame extends JFrame {

	private ClientContext clientContext;
	private JLabel examInfoLabel;
	private JTextArea text;
	private JLabel label;
	private JButton pre;
	private JButton next;
	private ArrayList<Option> options = new ArrayList<Option>();
	private JLabel timerLabel;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setExamFrame(this);
	}

	public ExamFrame() {
		this.setTitle("在线测评系统");
		this.setSize(700, 500);
		this.setResizable(false);
		// this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clientContext.exit();
			}
		});
		this.setLocationRelativeTo(null);

		this.setContentPane(createContentPanel());
	}

	private JPanel createContentPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		URL url = this.getClass().getResource("exam_title.png");
		ImageIcon icon = new ImageIcon(url);
		panel.add(BorderLayout.NORTH, new JLabel(icon, JLabel.CENTER));
		panel.add(BorderLayout.CENTER, createCenterPanel());
		panel.add(BorderLayout.SOUTH, createSPanel());
		return panel;
	}

	private JPanel createCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		examInfoLabel = new JLabel("姓名:XXX 编号:001 考试时间:20分钟 题量:20",
				JLabel.CENTER);
		panel.add(BorderLayout.NORTH, examInfoLabel);
		panel.add(BorderLayout.CENTER, createQuestionPanel());
		panel.add(BorderLayout.SOUTH, createOptionsPanel());
		return panel;
	}

	// --------- 滚动窗格 -------
	private JScrollPane createQuestionPanel() {
		JScrollPane panel = new JScrollPane();
		text = new JTextArea();
		text.setText("A\nB\nC\nD\n"); // 设置文本区的内容
		text.setLineWrap(true); // 设置文本区自动换行
		text.setFocusable(false); // 设置文本区中内容不可以修改

		panel.getViewport().add(text); //
		return panel;
	}

	private JPanel createOptionsPanel() {
		JPanel panel = new JPanel();
		Option box1 = new Option("A", 1);
		Option box2 = new Option("B", 2);
		Option box3 = new Option("C", 3);
		Option box4 = new Option("D", 4);
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		
		options.add(box1);
		options.add(box2);
		options.add(box3);
		options.add(box4);
		return panel;
	}
	
	private class Option extends JCheckBox{
		private int value;
		public Option(String name, int value){
			super(name);
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
	
	private JPanel createSPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		label = new JLabel("一共20题", JLabel.LEFT);
		panel.add(BorderLayout.WEST, label);
		panel.add(BorderLayout.CENTER, createBtnPanel());
		timerLabel = new JLabel("00:00:50", JLabel.RIGHT);
		panel.add(BorderLayout.EAST, timerLabel);
		return panel;
	}

	private JPanel createBtnPanel() {
		JPanel panel = new JPanel();
		pre = new JButton("前一题");
		pre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.pre();
			}
		});
		next = new JButton("后一题");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.next();
			}
		});
		JButton submit = new JButton("交卷");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.send();
			}
		});
		panel.add(pre);
		panel.add(next);
		panel.add(submit);
		return panel;
	}

	public void updateView(ExamInfo examInfo, QuestionInfo questionInfo) {
		int pageIndex = questionInfo.getPageIndex();
		if(pageIndex == 0)
			this.pre.setEnabled(false);
		else
			this.pre.setEnabled(true);
		if(pageIndex == examInfo.getTotalNumbers()-1)
			this.next.setEnabled(false);
		else
			this.next.setEnabled(true);
		examInfoLabel.setText(examInfo.toString());
		text.setText(questionInfo.getQuestion().toString());
		
		String text = String.format("一共%d题,现在是第%d题",
				examInfo.getTotalNumbers(), questionInfo.getPageIndex()+1);
		label.setText(text);
		updateOptions(questionInfo);
	}
	private void updateOptions(QuestionInfo questionInfo){
		ArrayList<Integer> userAnswers = questionInfo.getUserAnswers();
		for(Option option : options){
			option.setSelected(userAnswers.contains(option.getValue()));
		}
	}
	
	/**
	 * 保存用户选择的答案
	 * @return
	 */
	public ArrayList<Integer> getUserAnswers(){
		ArrayList<Integer> userAnswers = new ArrayList<Integer>();
		for(Option option : options){
			if(option.isSelected()){
				userAnswers.add(option.getValue());
			}
		}
		return userAnswers;
	}
	
	public void updateTimer(long sub){
		int hour = (int)(sub/1000/60/60);
		int minute = (int)(sub/1000/60%60);
		int second = (int)(sub/1000%60);
		String text = String.format("%02d:%02d:%02d", hour,minute,second);
		timerLabel.setText(text);
	}
}
