package my.view;

import java.awt.Graphics;
import javax.swing.JPanel;

import my.base.*;

public class GamePanel extends JPanel{
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public void display(Snake snake, Food food, Ground ground){
		//System.out.println("œ‘ æ√Ê∞Â...");
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(snake != null && food != null && ground != null){
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
		}
	}
}
