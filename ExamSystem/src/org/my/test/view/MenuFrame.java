package org.my.test.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.my.test.contol.ClientContext;

public class MenuFrame extends JFrame {

	private ClientContext clientContext;
	private JLabel userLabel;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setMenuFrame(this);
	}

	public MenuFrame() {
		this.setTitle("在线测评系统");
		this.setSize(800, 500);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clientContext.exit();
			}
		});
		this.setLocationRelativeTo(null);

		this.setContentPane(creatContentPanel());
	}

	public JPanel creatContentPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		// 获得当前类所在包下的路径作为
		URL url = this.getClass().getResource("title.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		panel.add(label, BorderLayout.NORTH);
		panel.add(createCenterPanel(), BorderLayout.CENTER);
		panel.add(new JLabel("版权所有，禁止盗版！", JLabel.RIGHT), BorderLayout.SOUTH);
		return panel;
	}

	public JPanel createCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		userLabel = new JLabel("欢迎xxx登陆考试系统!", JLabel.CENTER);
		panel.add(userLabel, BorderLayout.NORTH);
		panel.add(createBtnPanel(), BorderLayout.CENTER);
		return panel;
	}

	public JPanel createBtnPanel() {
		JPanel panel = new JPanel();
		JButton startButton = createBtn("开始", "start.png");
		panel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.start();
			}
		});
		JButton resultBtn = createBtn("分数", "sroce.png");
		resultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.getResult();
			}
		});
		panel.add(resultBtn);
		JButton ruleBtn = createBtn("规则", "rule.png");
		ruleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.showRule();
			}
		});
		panel.add(ruleBtn);
		JButton exitBtn = createBtn("离开", "exit.png");
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit();
			}
		});
		panel.add(exitBtn);
		return panel;
	}

	// 按钮和文字的排版
	public JButton createBtn(String name, String imageName) {
		URL url = this.getClass().getResource(imageName);
		ImageIcon icon = new ImageIcon(url);
		JButton button = new JButton(name, icon);
		button.setHorizontalTextPosition(SwingConstants.CENTER); // 水平方向
		button.setVerticalTextPosition(SwingConstants.BOTTOM); // 垂直方向
		return button;
	}

	public void updateMenuFrame() {
		String text = String.format("欢迎%s登陆考试系统!", 
				clientContext.getUser().getName());
		userLabel.setText(text);
		//设置颜色
		userLabel.setForeground(Color.red);
	}
	
}
