package java_Core.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo3 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		myPanel panel = new myPanel();
		frame.add(panel);
		frame.setVisible(true);
		
	}
}


class myPanel extends JPanel{
	public myPanel(){
		this.addChangeColor("À¶É«", Color.BLUE);
		this.addChangeColor("ºìÉ«", Color.RED);
	}
	
	public  void addChangeColor(String str, final Color color){
		JButton button = new JButton(str);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.this.setBackground(color);
			}
		});
		this.add(button);
	}
}