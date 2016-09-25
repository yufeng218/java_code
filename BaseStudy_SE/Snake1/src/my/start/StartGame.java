package my.start;

import javax.swing.JFrame;

import my.Controller.Controller;
import my.base.Food;
import my.base.Ground;
import my.base.Snake;
import my.view.GamePanel;



public class StartGame {

	public static void main(String[] args) {
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		GamePanel gamePanel = new GamePanel();
		
		Controller c = new Controller(snake, food, ground, gamePanel);
		snake.addSnakeListener(c);
		gamePanel.addKeyListener(c);
		
		JFrame frame = new JFrame("贪吃蛇游戏");
		frame.setSize(600+20, 600+40);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		
		c.startGame();		//开始游戏..
		frame.setVisible(true);
	}

}
