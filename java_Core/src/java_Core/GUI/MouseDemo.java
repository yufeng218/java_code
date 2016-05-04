package java_Core.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;

public class MouseDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("���ڵı���");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		MousePanel panel = new MousePanel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}

class MousePanel extends JPanel{
	private ArrayList<Rectangle2D> list = new ArrayList<Rectangle2D>();
	public MousePanel(){
		
		this.addMouseListener(new MouseAdapter(){
			//������꣬���ƾ���
			@Override
			public void mousePressed(MouseEvent e) {
				Point2D point = e.getPoint();
				if(find(point) == null)
					list.add(new Rectangle2D.Double(e.getX()-15, e.getY()-15, 30, 30));
				repaint();
			}
			
			//˫�����,ɾ������
			@Override
			public void mouseClicked(MouseEvent e) {
				Rectangle2D rect = find(e.getPoint());
				if(e.getClickCount() >= 2 && rect != null){
					list.remove(rect);
				}
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
			//��ק����
			@Override
			public void mouseDragged(MouseEvent e) {
				Rectangle2D rect = find(e.getPoint());
				if(rect != null){
//					list.remove(rect);
//					list.add(new Rectangle2D.Double(e.getX()-15, e.getY()-15, 30, 30));
					rect.setFrame(e.getX()-15, e.getY()-15, 30, 30);
				}
				repaint();
			}
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D rectangle2d : list) {
			g2.draw(rectangle2d);
		}
	}
	
	/*
	 * list�����еľ����Ƿ����ĳһ�㣬�����ؾ���
	 */
	private Rectangle2D find(Point2D point){
		
		for (Rectangle2D rect : list) {
			if(rect.contains(point))
				return rect;
		}
		return null;
	}
}
