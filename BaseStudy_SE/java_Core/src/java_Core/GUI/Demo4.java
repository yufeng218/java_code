package java_Core.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Demo4 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("窗口");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		myPanel4 panel = new myPanel4();
		frame.add(panel);
		frame.setVisible(true);
		
	}
}


class myPanel4 extends JPanel{
	public myPanel4(){
		this.addChangeColor("蓝色", Color.BLUE);
		this.addChangeColor("红色", Color.RED);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标释放了");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("鼠标按下了");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("鼠标移出了");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标移入了");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	public  void addChangeColor(String str, final Color color){
		JButton button = new JButton(str);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel4.this.setBackground(color);
			}
		});
		this.add(button);
	}
}