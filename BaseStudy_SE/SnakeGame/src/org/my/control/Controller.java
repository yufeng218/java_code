package org.my.control;

import org.my.base.*;
import org.my.listener.SnakeListener;
import org.my.util.Global;
import org.my.view.*;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 控制器类
 * @author he
 *
 */
public class Controller extends KeyAdapter implements SnakeListener{
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int keycode = e.getKeyCode();
		switch (keycode) {
			case KeyEvent.VK_UP:
				snake.changeDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.changeDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snake.changeDirection(Snake.RIGHT);
				break;
		}
	}

	@Override
	public void snakeMoved(Snake snake) {
		//System.out.println("判断蛇是否碰到蛇身，食物，障碍物");
		//显示蛇的身体、食物、障碍物
		if(food.isEatBySnake(snake)){
			snake.eatFood(food);
			//食物被吃掉，有新的食物产生
			food.addFood(ground.getPoint());
		}
		
		if(ground.isEatBySnake(snake)){
			snake.setLife(false);
			JOptionPane.showConfirmDialog(null, "Game Over!");
			//System.exit(0);
		}
		
		
		if(snake.isEatSelf()){
			snake.setLife(false);
			JOptionPane.showConfirmDialog(null, "Game Over!");
			//System.exit(0);
		}
		
		gamePanel.display(snake, food, ground);
	}
	
	public void startGame(){
		System.out.println("游戏开始...");
		snake.start();
		food.addFood(ground.getPoint());
	}
	
}
