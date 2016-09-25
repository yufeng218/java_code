package org.my.test;

import javax.swing.JFrame;

import org.my.base.Snake;
import org.my.base.Food;
import org.my.base.Ground;
import org.my.control.Controller;
import org.my.view.GamePanel;

public class SnakeGameTest {

	public static void main(String[] args) {
		
		//ʵ�����Ĵ���
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		
		//��ͼ����Ĵ���
		GamePanel gamePanel = new GamePanel();
		
		//�������Ĵ��� --> �����ߵļ�����Ҳ�Ǽ��̵ļ�����
		Controller c = new Controller(snake, food, ground, gamePanel);
		
		snake.addSnakeListener(c);
		gamePanel.addKeyListener(c);
	
		JFrame frame = new JFrame("̰����version1.0");
		frame.setSize(300+18, 300+45);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//������ý���
		gamePanel.setFocusable(true);
		frame.add(gamePanel);
		
		//������Ϸ
		c.startGame();
		//��ʾ
		frame.setVisible(true);
		
	}

}
