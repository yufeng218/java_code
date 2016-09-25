package java_Core.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo2 {
	public static void main(String[] args) {
		
		myFrame frame = new myFrame();
		frame.setVisible(true);
	}

}

class myFrame extends JFrame{
	private JLabel name = new JLabel("����:"); //��ǩ
	private JTextField nameField = new JTextField(10); //�ı���
	private JTextArea jta = new JTextArea(50, 50); //�ı���
	private JButton bt1 = new JButton("ȷ��");
	private JButton bt2 = new JButton("ȡ��");
	
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	
	public myFrame(){
		setSize(600, 600); 
		setTitle("��һ������");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����ȷ��");
			}
		});
		
		//jp1.setLayout(new GridLayout(1, 2));
		jp1.add(name);
		jp1.add(nameField);
		
		jp2.add(jta);
		
		jp3.setSize(600, 50);
		jp3.add(bt1);
		jp3.add(bt2);
		
		setLayout(new BorderLayout());
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
	}
	
	
}


/*
class myPanel extends JPanel{
	private JLabel name = new JLabel("����:"); //��ǩ
	private JTextField nameField = new JTextField(10); //�ı���
	private JTextArea jta = new JTextArea(10, 10); //�ı���
	private JButton bt1 = new JButton("ȷ��");
	private JButton bt2 = new JButton("ȡ��");
	
}*/