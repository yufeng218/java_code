package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.my.util.Global;

/**
 * 食物类
 * 
 * @author he
 *
 */
public class Food extends Point {

	/*
	 * 画出蛇本身
	 */
	public void drawMe(Graphics g) {
		//System.out.println("食物正在画自己...");
		g.setColor(Color.RED);
		g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}

	/*
	 * 蛇是否碰到食物
	 */
	public boolean isEatBySnake(Snake snake) {
		//System.out.println("判断蛇是否碰到了食物...");
		Point head = snake.getHead();
		if(head.equals(this)){
			return true;
		}
		return false;
	}

	public void addFood(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
}
