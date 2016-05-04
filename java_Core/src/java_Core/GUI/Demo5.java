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
		
		JFrame frame = new JFrame("����");
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
				repaint(); //�Զ�����paintComponent
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paintComponent(g); //���ø���ķ����������
		/*g.drawLine(10, 10, 100, 100); //ֱ���������յ����
		g.drawRect(10, 10, 100, 100); //���������Ͻ����ꡢ�������*/
		
		Rectangle2D rect = new Rectangle2D.Double(x, y, 100, 100);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(rect);
		
	}
	
}