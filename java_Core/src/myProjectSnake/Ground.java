package myProjectSnake;

/**
 * 障碍物
 * @author he
 *
 */
public class Ground {
	
	/*
	 * 
	 */
	public void drawMe(){
		System.out.println("障碍物正在画自己...");
	}
	
	/*
	 * 蛇是否碰到障碍物
	 */
	public boolean isEatBySnake(Snake snake){
		System.out.println("判断蛇是否碰到了障碍物...");
		return false;
	}
}
