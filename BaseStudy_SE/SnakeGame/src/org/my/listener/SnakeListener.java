package org.my.listener;

import org.my.base.Snake;

/**
 * 蛇的监听器
 * @author he
 *
 */
public interface SnakeListener {
	/**
	 * 该方法判断蛇移动是否碰到自己、障碍物、食物;
	 * @param snake
	 */
	public void snakeMoved(Snake snake);
}
