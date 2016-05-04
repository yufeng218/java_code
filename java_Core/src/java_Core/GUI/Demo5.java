package java_Core.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Demo5 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("窗口");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		myPanel5 panel = new myPanel5();
		frame.add(panel);
		frame.setVisible(true);
		
	}
}


class myPanel5 extends JPanel{
	private int x,y;
	public myPanel5(){
		this.addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				System.out.println(x+","+y);
				repaint(); //自动调用paintComponent
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		super.paintComponent(g); //调用父类的方法可以清空
		/*g.drawLine(10, 10, 100, 100); //直线由起点和终点决定
		g.drawRect(10, 10, 100, 100); //矩形由左上角坐标、长宽决定*/
		
		Rectangle2D rect = new Rectangle2D.Double(x, y, 100, 100);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(rect);
		
	}
	
}