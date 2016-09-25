package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import org.my.listener.SnakeListener;
import org.my.util.Global;

/**
 * 蛇类
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
	//private int direction;  //存储当前方向
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
	 * 获取蛇头
	 */
	public Point getHead(){
		return body.getFirst();
	}

	/*
	 * 蛇移动
	 */
	public void move() {
		//System.out.println("蛇正在移动...");
		//去尾加头
		if(this.oldDirection + this.newDirection != 0)
			this.oldDirection = this.newDirection;
		int x = body.getFirst().x + oldDirection/10;
		int y = body.getFirst().y + oldDirection%10;
		if(y < 0) y = Global.HEIGHT - 1;
		if(y >= Global.HEIGHT) y = 0;
		if(x < 0) x = Global.WIDTH - 1;
		if(x >= Global.HEIGHT) x = 0;
		
		tail = body.removeLast();	//去尾
		body.addFirst(new Point(x,y)); //加头
	}

	/*
	 * 蛇吃食物
	 */
	public void eatFood(Food food) {
		//System.out.println("蛇在吃食物...");
		body.addLast(tail); //加上尾巴
	}

	/*
	 * 蛇改变方向
	 */
	public void changeDirection(int direction) {
		//System.out.println("蛇正在改变方向...");
		this.newDirection = direction;
	}

	/*
	 * 蛇画自己
	 */
	public void drawMe(Graphics g) {
		//System.out.println("蛇正在画自己...");
		g.setColor(Color.blue);
		for (Point point : body) {
			g.fill3DRect(point.x * Global.CELL_SIZE,
					point.y * Global.CELL_SIZE, Global.CELL_SIZE,
					Global.CELL_SIZE, true);
		}
	}

	/*
	 * 是否吃到自己
	 */
	public boolean isEatSelf() {
		//System.out.println("判断蛇是否碰到了自己...");
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
				// 蛇是否碰到自己、障碍物、食物
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
