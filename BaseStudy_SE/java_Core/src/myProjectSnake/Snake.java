package myProjectSnake;

/**
 * 蛇类
 * @author he
 *
 */
public class Snake {
	
	/*
	 * 蛇移动
	 */
	public void move(){
		System.out.println("蛇正在移动...");
	}
	
	/*
	 * 蛇吃食物
	 */
	public void eatFood(Food food){
		System.out.println("蛇在吃食物...");
	}
	
	/*
	 * 蛇改变方向
	 */
	public void changeDirection(){
		System.out.println("蛇正在改变方向...");
	}
	
	/*
	 * 蛇画自己
	 */
	public void drawMe(){
		System.out.println("蛇正在画自己...");
	}
	
	/*
	 * 是否吃到自己
	 */
	public boolean isEatSelf(){
		System.out.println("判断蛇是否碰到了自己...");
		return false;
	}
	
	
	
}



