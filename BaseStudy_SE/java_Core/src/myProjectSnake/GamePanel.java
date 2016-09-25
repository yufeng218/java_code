package myProjectSnake;

import java.awt.Graphics;

import javax.swing.*;
/**
 * 游戏操作界面
 * @author he
 *
 */
public class GamePanel extends JPanel{
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public void display(Snake snake, Food food, Ground ground){
		System.out.println("面板正在显示...");
		repaint();
		this.snake = snake;
		this.food =  food;
		this.ground = ground;
	}
	
	@Override
	public void paintComponents(Graphics g) {
		//super.paintComponents(g);
		if(snake != null && food != null & ground != null){
			snake.drawMe();
			food.drawMe();
			ground.drawMe();
		}
	}
	
}
