package myProjectSnake;

/**
 * ����
 * @author he
 *
 */
public class Snake {
	
	/*
	 * ���ƶ�
	 */
	public void move(){
		System.out.println("�������ƶ�...");
	}
	
	/*
	 * �߳�ʳ��
	 */
	public void eatFood(Food food){
		System.out.println("���ڳ�ʳ��...");
	}
	
	/*
	 * �߸ı䷽��
	 */
	public void changeDirection(){
		System.out.println("�����ڸı䷽��...");
	}
	
	/*
	 * �߻��Լ�
	 */
	public void drawMe(){
		System.out.println("�����ڻ��Լ�...");
	}
	
	/*
	 * �Ƿ�Ե��Լ�
	 */
	public boolean isEatSelf(){
		System.out.println("�ж����Ƿ��������Լ�...");
		return false;
	}
	
	
	
}



