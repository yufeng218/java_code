package java_Core.GUI;

import java.awt.*;
import javax.swing.*;

public class Demo1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("第一个窗口");
		JButton button = new JButton("确定");
		JButton button1 = new JButton("确定1");
		JButton button2 = new JButton("确定2");
		JButton button3 = new JButton("确定3");
		JButton button4 = new JButton("确定4");
		JButton button5 = new JButton("确定5");
		JButton button6 = new JButton("确定6");
		JButton button7 = new JButton("确定7");
		JButton button8 = new JButton("确定8");
		JButton button9 = new JButton("确定9");
		JButton button0 = new JButton("确定0");
		frame.setSize(1028, 600); //设置大小尺寸
		//frame.setResizable(false); //设置窗口的大小不可改变
		frame.setLocationRelativeTo(null);//窗口显示在屏幕中间
		//关闭窗口后程序退出
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*frame.setLayout(new FlowLayout()); //水平布局
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
		
		
		frame.setLayout(new BorderLayout()); //边界布局
		frame.add(button5, BorderLayout.EAST); 
		frame.add(button6, BorderLayout.SOUTH); 
		frame.add(button7, BorderLayout.WEST); 
		frame.add(button8, BorderLayout.WEST); 
		frame.add(button9, BorderLayout.CENTER); 
		
//		frame.setLayout(new GridLayout(2, 3)); //网格布局，2行3列
//		frame.add(button4); 
//		frame.add(button5); 
//		frame.add(button6); 
//		frame.add(button7); 
//		frame.add(button8); 
//		frame.add(button9);
		
		frame.setVisible(true);	//使窗口可见

	}

}
