package my.base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import my.Controller.ShowSize;

public class Food extends Point {

	public void createFood(Snake snake, Ground ground) {
		int i, j;
		do {
			i = new Random().nextInt(ShowSize.WIDTH);
			j = new Random().nextInt(ShowSize.HEIGHT);
		} while (snake.body.contains(new Point(i, j))
				|| ground.rocks[i][j] == 1);
		this.x = i;
		this.y = j;
	}

	public boolean isEatBySnake(Snake snake) {
		//System.out.println("食物是否被蛇吃");
		// 蛇头的坐标和食物的坐标是否一样
		if (snake.getHead().equals(this))
			return true;
		return false;
	}

	public void drawMe(Graphics g) {
		//System.out.println("食物画自己");
		g.setColor(Color.RED);
		g.fillRect(this.x * ShowSize.CELL_SIZE, this.y * ShowSize.CELL_SIZE,
				ShowSize.CELL_SIZE, ShowSize.CELL_SIZE);
	}
}
