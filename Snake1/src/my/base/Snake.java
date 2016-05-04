package my.base;

import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import my.Controller.ShowSize;

public class Snake {
	private SnakeListener snakeListener;
	public LinkedList<Point> body = new LinkedList<Point>();
	public final static int UP = -1;
	public final static int DOWN = 1;
	public final static int LEFT = -10;
	public final static int RIGHT = 10;
	private int oldDirection,newDirection;
	private Point tail;
	private boolean life = true;
	private int time;
	
	public Snake() {
		// �����ʵ��
		for(int i = 0; i < 3; i++){
			int x = ShowSize.WIDTH/2 - i;
			int y = ShowSize.HEIGHT/2;
			body.add(new Point(x, y));
		}
		this.oldDirection = this.newDirection = this.RIGHT;
	}
	
	public void setDirection(int direction){
		this.newDirection = direction;
	}

	public void move() {
		//System.out.println("�������ƶ�...");
		Point head = body.getFirst();
		if(this.newDirection + this.oldDirection != 0)
			this.oldDirection = this.newDirection;
		int x = head.x + oldDirection / 10;
		int y = head.y + oldDirection % 10;
		body.addFirst(new Point(x, y));
		tail = body.removeLast();
	}

	public boolean isEatSelf() {
		//System.out.println("���Ƿ������Լ�");
		for(int index = 1; index < body.size(); index++){
			if(body.get(index).equals(this.getHead()))
				return true;
		}
		return false;
	}

	public void eatFood() {
		//System.out.println("�߳Ե�ʳ��");
		//�߳�ʳ����ǰ�ȥ����β���ټ���
		body.addLast(tail);
	}
	
	public Point getHead(){
		return body.getFirst();
	}
	
	public void drawMe(Graphics g) {
		//System.out.println("�����ڻ��Լ�..");
		g.setColor(Color.green);
		for (Point point : body) {
			g.fill3DRect(point.x * ShowSize.CELL_SIZE, point.y
					* ShowSize.CELL_SIZE, ShowSize.CELL_SIZE, ShowSize.CELL_SIZE, true);
		}
	}

	/*
	 * �������Ӽ�����
	 */
	public void addSnakeListener(SnakeListener snakeListener) {
		this.snakeListener = snakeListener;
	}

	public void start() {
		new myGame().start();
	}
	
	public void setLife(boolean life){
		this.life = life;
	}
	
	public void setTime(int time){
		this.time += time;
	}
	
	private class myGame extends Thread {

		@Override
		public void run() {
			while (life) {
				move();
				snakeListener.SnakeMove();
				try {
					Thread.sleep(300 - time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
