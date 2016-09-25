package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import org.my.util.Global;

/**
 * �ϰ���
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
		//System.out.println("�ϰ������ڻ��Լ�...");
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
	 * ���Ƿ������ϰ���
	 */
	public boolean isEatBySnake(Snake snake) {
		//System.out.println("�ж����Ƿ��������ϰ���...");
		Point head = snake.getHead();
		for (int x = 0; x < Global.HEIGHT; x++)
			for (int y = 0; y < Global.WIDTH; y++) {
				if(rocks[x][y] == 1 && head.x == x && head.y == y)
					return true;
			}
		return false;
	}
	
	/**
	 * ����ʳ����λ��,ʳ�ﲻ��������ϰ����λ��;
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
