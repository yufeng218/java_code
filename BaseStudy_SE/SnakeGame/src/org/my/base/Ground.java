package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import org.my.util.Global;

/**
 * 障碍物
 * 
 * @author he
 *
 */
public class Ground {

	private int[][] rocks = new int[Global.WIDTH][Global.HEIGHT];

	public Ground() {
		for (int x = 0; x < Global.HEIGHT; x++)
			for (int y = 0; y < Global.WIDTH; y++) {
				if (x == 0 || x == Global.HEIGHT - 1)
					rocks[x][y] = 1;
				if (y == 0 || y == Global.WIDTH - 1)
					rocks[x][y] = 1;
			}
	}

	/*
	 * 
	 */
	public void drawMe(Graphics g) {
		//System.out.println("障碍物正在画自己...");
		g.setColor(Color.gray);
		for (int x = 0; x < Global.HEIGHT; x++)
			for (int y = 0; y < Global.WIDTH; y++) {
				if (rocks[x][y] == 1) {
					g.fillRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
							Global.CELL_SIZE, Global.CELL_SIZE);
				}
			}
	}

	/*
	 * 蛇是否碰到障碍物
	 */
	public boolean isEatBySnake(Snake snake) {
		//System.out.println("判断蛇是否碰到了障碍物...");
		Point head = snake.getHead();
		for (int x = 0; x < Global.HEIGHT; x++)
			for (int y = 0; y < Global.WIDTH; y++) {
				if(rocks[x][y] == 1 && head.x == x && head.y == y)
					return true;
			}
		return false;
	}
	
	/**
	 * 设置食物点的位置,食物不会出现在障碍物的位置;
	 * @return
	 */
	public Point getPoint(){
		int x,y;
		do{
			x = new Random().nextInt(Global.WIDTH);
			y = new Random().nextInt(Global.HEIGHT);
		}while(rocks[x][y] == 1);
		
		return new Point(x, y);
	}
}
