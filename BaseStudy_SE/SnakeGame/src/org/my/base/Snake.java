package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import org.my.listener.SnakeListener;
import org.my.util.Global;

/**
 * ����
 * 
 * @author he
 *
 */
public class Snake {

	private SnakeListener snakeListener;
	private boolean life = true;
	private LinkedList<Point> body = new LinkedList<Point>();
	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int LEFT = -10;
	public static final int RIGHT = 10;
	//private int direction;  //�洢��ǰ����
	private int oldDirection,newDirection; 
	private Point tail;
	
	public Snake() {
		init();
	}

	private void init() {
		int x = Global.WIDTH / 2;
		int y = Global.HEIGHT / 2;
		for (int i = 0; i < 3; i++) {
			body.add(new Point(x - i, y));
		}
		this.oldDirection = this.newDirection = RIGHT;
	}
	
	public void setLife(boolean life){
		this.life = life;
	}
	
	/*
	 * ��ȡ��ͷ
	 */
	public Point getHead(){
		return body.getFirst();
	}

	/*
	 * ���ƶ�
	 */
	public void move() {
		//System.out.println("�������ƶ�...");
		//ȥβ��ͷ
		if(this.oldDirection + this.newDirection != 0)
			this.oldDirection = this.newDirection;
		int x = body.getFirst().x + oldDirection/10;
		int y = body.getFirst().y + oldDirection%10;
		if(y < 0) y = Global.HEIGHT - 1;
		if(y >= Global.HEIGHT) y = 0;
		if(x < 0) x = Global.WIDTH - 1;
		if(x >= Global.HEIGHT) x = 0;
		
		tail = body.removeLast();	//ȥβ
		body.addFirst(new Point(x,y)); //��ͷ
	}

	/*
	 * �߳�ʳ��
	 */
	public void eatFood(Food food) {
		//System.out.println("���ڳ�ʳ��...");
		body.addLast(tail); //����β��
	}

	/*
	 * �߸ı䷽��
	 */
	public void changeDirection(int direction) {
		//System.out.println("�����ڸı䷽��...");
		this.newDirection = direction;
	}

	/*
	 * �߻��Լ�
	 */
	public void drawMe(Graphics g) {
		//System.out.println("�����ڻ��Լ�...");
		g.setColor(Color.blue);
		for (Point point : body) {
			g.fill3DRect(point.x * Global.CELL_SIZE,
					point.y * Global.CELL_SIZE, Global.CELL_SIZE,
					Global.CELL_SIZE, true);
		}
	}

	/*
	 * �Ƿ�Ե��Լ�
	 */
	public boolean isEatSelf() {
		//System.out.println("�ж����Ƿ��������Լ�...");
		for(int index = 1; index < body.size(); index++){
			if(body.get(index).equals(this.getHead()))
				return true;
		}
		return false;
	}

	public void addSnakeListener(SnakeListener snakeListener) {

		if (snakeListener != null) {
			this.snakeListener = snakeListener;
		}

	}

	public void start() {
		new SnakeDriver().start();
	}

	private class SnakeDriver extends Thread {
		@Override
		public void run() {
			while (life) {
				move();
				// ���Ƿ������Լ����ϰ��ʳ��
				snakeListener.snakeMoved(Snake.this);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
