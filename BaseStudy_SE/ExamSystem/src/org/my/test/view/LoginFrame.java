package org.my.test.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.my.test.contol.ClientContext;

/**
 * 登录界面
 * 
 * @author he
 *
 */
public class LoginFrame extends JFrame {
	private ClientContext clientContext;
	private JTextField idField;
	private JPasswordField passField;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setLoginFrame(this);
	}

	public LoginFrame() {
		this.setTitle("在线考试系统");
		this.setSize(400, 200);
		this.setResizable(false);// 窗体的大小不可改变
		// this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clientContext.exit();
			}
		});
		this.setLocationRelativeTo(null);

		// 设置窗体的内容窗格
		this.setContentPane(createContentPane());
	}

	// 增加3个面板
	private JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createNPanel(), BorderLayout.NORTH);
		panel.add(createCenterPanel(), BorderLayout.CENTER);
		panel.add(createSPanel(), BorderLayout.SOUTH);
		return panel;
	}

	// 第一个面板
	private JPanel createNPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("登录系统", JLabel.CENTER);
		panel.add(label);
		return panel;
	}

	// 第二个面板
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createIdPassPanel(), BorderLayout.NORTH);
		return panel;
	}

	private JPanel createIdPassPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(createIdPanel());
		panel.add(createPassPanel());
		return panel;
	}

	private JPanel createIdPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("编号：");
		idField = new JTextField(10);
		panel.add(label, BorderLayout.WEST);
		panel.add(idField, BorderLayout.CENTER);
		return panel;
	}

	private JPanel createPassPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("密码：");
		passField = new JPasswordField(10);
		panel.add(label, BorderLayout.WEST);
		panel.add(passField, BorderLayout.CENTER);
		return panel;
	}

	// 第三个面板
	private JPanel createSPanel() {
		JPanel panel = new JPanel();
		JButton loginBtn = new JButton("登录");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clientContext.logon();
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(LoginFrame.this,
							e2.getMessage());
				}
			}
		});
		JButton cancelBtn = new JButton("取消");
		panel.add(loginBtn);
		panel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.exit();
			}
		});
		return panel;
	}

	/**
	 * 获取编码id内容
	 * 
	 * @return
	 */
	public String getId() {
		return idField.getText().trim();
	}

	/**
	 * 获取编码对应的密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return new String(passField.getPassword());
	}
}
