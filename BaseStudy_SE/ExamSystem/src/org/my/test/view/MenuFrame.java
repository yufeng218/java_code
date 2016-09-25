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
		this.setTitle("���߲���ϵͳ");
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
		// ��õ�ǰ�����ڰ��µ�·����Ϊ
		URL url = this.getClass().getResource("title.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		panel.add(label, BorderLayout.NORTH);
		panel.add(createCenterPanel(), BorderLayout.CENTER);
		panel.add(new JLabel("��Ȩ���У���ֹ���棡", JLabel.RIGHT), BorderLayout.SOUTH);
		return panel;
	}

	public JPanel createCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		userLabel = new JLabel("��ӭxxx��½����ϵͳ!", JLabel.CENTER);
		panel.add(userLabel, BorderLayout.NORTH);
		panel.add(createBtnPanel(), BorderLayout.CENTER);
		return panel;
	}

	public JPanel createBtnPanel() {
		JPanel panel = new JPanel();
		JButton startButton = createBtn("��ʼ", "start.png");
		panel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.start();
			}
		});
		JButton resultBtn = createBtn("����", "sroce.png");
		resultBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.getResult();
			}
		});
		panel.add(resultBtn);
		JButton ruleBtn = createBtn("����", "rule.png");
		ruleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.showRule();
			}
		});
		panel.add(ruleBtn);
		JButton exitBtn = createBtn("�뿪", "exit.png");
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit();
			}
		});
		panel.add(exitBtn);
		return panel;
	}

	// ��ť�����ֵ��Ű�
	public JButton createBtn(String name, String imageName) {
		URL url = this.getClass().getResource(imageName);
		ImageIcon icon = new ImageIcon(url);
		JButton button = new JButton(name, icon);
		button.setHorizontalTextPosition(SwingConstants.CENTER); // ˮƽ����
		button.setVerticalTextPosition(SwingConstants.BOTTOM); // ��ֱ����
		return button;
	}

	public void updateMenuFrame() {
		String text = String.format("��ӭ%s��½����ϵͳ!", 
				clientContext.getUser().getName());
		userLabel.setText(text);
		//������ɫ
		userLabel.setForeground(Color.red);
	}
	
}
