package org.my.listener;

import org.my.base.Snake;

/**
 * �ߵļ�����
 * @author he
 *
 */
public interface SnakeListener {
	/**
	 * �÷����ж����ƶ��Ƿ������Լ����ϰ��ʳ��;
	 * @param snake
	 */
	public void snakeMoved(Snake snake);
}
