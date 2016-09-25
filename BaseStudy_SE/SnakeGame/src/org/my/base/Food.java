package org.my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.my.util.Global;

/**
 * ʳ����
 * 
 * @author he
 *
 */
public class Food extends Point {

	/*
	 * �����߱���
	 */
	public void drawMe(Graphics g) {
		//System.out.println("ʳ�����ڻ��Լ�...");
		g.setColor(Color.RED);
		g.fill3DRect(x * Global.CELL_SIZE, y * Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}

	/*
	 * ���Ƿ�����ʳ��
	 */
	public boolean isEatBySnake(Snake snake) {
		//System.out.println("�ж����Ƿ�������ʳ��...");
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
