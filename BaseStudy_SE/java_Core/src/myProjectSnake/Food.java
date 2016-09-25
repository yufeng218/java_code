package myProjectSnake;

/**
 * 食物类
 * @author he
 *
 */
public class Food {
	
	/*
	 * 画出蛇本身
	 */
	public void drawMe(){
		System.out.println("食物正在画自己...");
	}
	
	/*
	 * 蛇是否碰到食物
	 */
	public boolean isEatBySnake(Snake snake){
		System.out.println("判断蛇是否碰到了食物...");
		return false;
	}
	
}
