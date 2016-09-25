package myProjectSnake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ¿ØÖÆÆ÷Àà
 * @author he
 *
 */
public class Controller extends KeyAdapter{
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
		
		snake.changeDirection();
	}
	
}
