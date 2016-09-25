package my.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import my.base.*;
import my.view.GamePanel;

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
	
	/*
	 * （非 Javadoc） 监听蛇
	 * @see my.base.SnakeListener#SnakeMove()
	 */
	@Override
	public void SnakeMove() {
		//System.out.println("蛇是否碰到障碍物、自己、食物...");
		
		if(food.isEatBySnake(snake)){
			snake.eatFood();
			//吃掉食物之后重生成食物
			food.createFood(snake, ground);
			//吃掉食物后蛇移动速度变快
			snake.setTime(20);
		}
		
		if(ground.isEatBySnake(snake) || snake.isEatSelf()){
			snake.setLife(false);
			JOptionPane.showMessageDialog(null, "Game Over!");
		}
		
		gamePanel.display(snake, food, ground);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_UP:
				//System.out.println("按上....");
				snake.setDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				//System.out.println("按下....");
				snake.setDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				//System.out.println("按左....");
				snake.setDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				//System.out.println("按右....");
				snake.setDirection(Snake.RIGHT);
				break;
		}
	}
	
	public void startGame(){
		snake.start(); 		//开始游戏..
		food.createFood(snake, ground);	//创建食物
	}
	
}
