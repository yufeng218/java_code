package java_Core.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.*;

public class KeyDemo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("窗口的标题");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		KeyPanel panel = new KeyPanel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}

class KeyPanel extends JPanel{
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();
	private Point2D start = new Point2D.Double(10, 10);
	private Point2D end;
	public KeyPanel(){
		
		this.setFocusable(true); //设置焦点在面板上s
		
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				//键盘的键值
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					addline(0, -20);
					break;
				case KeyEvent.VK_DOWN:
					addline(0, 20);
					break;
				case KeyEvent.VK_LEFT:
					addline(-20, 0);
					break;
				case KeyEvent.VK_RIGHT:
					addline(20, 0);
					break;
				default:
					break;
				}
				
			}

			private void addline(int dx, int dy) {
				end = new Point2D.Double(start.getX()+dx,start.getY()+dy);
				Line2D line = new Line2D.Double(start, end);
				lines.add(line);
				start = end; //上次的结束点是下次的起点
				repaint();
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Line2D line2d : lines) {
			g2.draw(line2d);
		}
	}
	
	
}
