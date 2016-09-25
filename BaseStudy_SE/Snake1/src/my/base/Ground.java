package my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import my.Controller.ShowSize;

public class Ground {
	public int[][] rocks = new int[ShowSize.WIDTH][ShowSize.HEIGHT];

	public Ground() {
		for (int x = 0; x < ShowSize.WIDTH; x++)
			for (int y = 0; y < ShowSize.HEIGHT; y++) {
				if (x == 0 || x == ShowSize.WIDTH - 1 || y == 0
						|| y == ShowSize.HEIGHT - 1) {
					rocks[x][y] = 1;
				}
			}
	}

	public boolean isEatBySnake(Snake snake) {
		//System.out.println("障碍物是否被蛇吃");
		Point head = snake.getHead();
		if(rocks[head.x][head.y] == 1)
			return true;
		return false;
	}

	public void drawMe(Graphics g) {
		//System.out.println("障碍物画自己");
		g.setColor(Color.gray);
		for (int x = 0; x < ShowSize.WIDTH; x++)
			for (int y = 0; y < ShowSize.HEIGHT; y++) {
				if (rocks[x][y] == 1) {
					g.fill3DRect(x * ShowSize.CELL_SIZE,
							y * ShowSize.CELL_SIZE, ShowSize.CELL_SIZE,
							ShowSize.CELL_SIZE, true);
				}
			}

	}
}
