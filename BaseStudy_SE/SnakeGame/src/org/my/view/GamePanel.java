package org.my.view;

import java.awt.Graphics;
import javax.swing.JPanel;
import org.my.base.*;
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
		//System.out.println("面板正在显示...");
		this.snake = snake;
		this.food =  food;
		this.ground = ground;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //清空面板
		if(snake != null && food != null & ground != null){
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
		}
	}
	
}
