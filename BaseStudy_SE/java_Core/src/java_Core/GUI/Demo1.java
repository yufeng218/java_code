package java_Core.GUI;

import java.awt.*;
import javax.swing.*;

public class Demo1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("��һ������");
		JButton button = new JButton("ȷ��");
		JButton button1 = new JButton("ȷ��1");
		JButton button2 = new JButton("ȷ��2");
		JButton button3 = new JButton("ȷ��3");
		JButton button4 = new JButton("ȷ��4");
		JButton button5 = new JButton("ȷ��5");
		JButton button6 = new JButton("ȷ��6");
		JButton button7 = new JButton("ȷ��7");
		JButton button8 = new JButton("ȷ��8");
		JButton button9 = new JButton("ȷ��9");
		JButton button0 = new JButton("ȷ��0");
		frame.setSize(1028, 600); //���ô�С�ߴ�
		//frame.setResizable(false); //���ô��ڵĴ�С���ɸı�
		frame.setLocationRelativeTo(null);//������ʾ����Ļ�м�
		//�رմ��ں�����˳�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*frame.setLayout(new FlowLayout()); //ˮƽ����
		frame.add(button); 
		frame.add(button1); 
		frame.add(button2); 
		frame.add(button3); 
		frame.add(button4); 
		frame.add(button5); 
		frame.add(button6); 
		frame.add(button7); 
		frame.add(button8); 
		frame.add(button9); 
		frame.add(button0); */
		
		
		frame.setLayout(new BorderLayout()); //�߽粼��
		frame.add(button5, BorderLayout.EAST); 
		frame.add(button6, BorderLayout.SOUTH); 
		frame.add(button7, BorderLayout.WEST); 
		frame.add(button8, BorderLayout.WEST); 
		frame.add(button9, BorderLayout.CENTER); 
		
//		frame.setLayout(new GridLayout(2, 3)); //���񲼾֣�2��3��
//		frame.add(button4); 
//		frame.add(button5); 
//		frame.add(button6); 
//		frame.add(button7); 
//		frame.add(button8); 
//		frame.add(button9);
		
		frame.setVisible(true);	//ʹ���ڿɼ�

	}

}
