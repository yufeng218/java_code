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
	 * ���� Javadoc�� ������
	 * @see my.base.SnakeListener#SnakeMove()
	 */
	@Override
	public void SnakeMove() {
		//System.out.println("���Ƿ������ϰ���Լ���ʳ��...");
		
		if(food.isEatBySnake(snake)){
			snake.eatFood();
			//�Ե�ʳ��֮��������ʳ��
			food.createFood(snake, ground);
			//�Ե�ʳ������ƶ��ٶȱ��
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
				//System.out.println("����....");
				snake.setDirection(Snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				//System.out.println("����....");
				snake.setDirection(Snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				//System.out.println("����....");
				snake.setDirection(Snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				//System.out.println("����....");
				snake.setDirection(Snake.RIGHT);
				break;
		}
	}
	
	public void startGame(){
		snake.start(); 		//��ʼ��Ϸ..
		food.createFood(snake, ground);	//����ʳ��
	}
	
}
