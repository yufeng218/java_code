package java_Core3;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class Worm {
	private LinkedList<Node> nodes = new LinkedList<Node>();
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	private int dir;//存储当前方向
	public Worm(){
		nodes.add(new Node(3,9));
		nodes.add(new Node(4,9));
		nodes.add(new Node(5,9));
		nodes.add(new Node(5,10));
		nodes.add(new Node(5,11));
		nodes.add(new Node(6,11));
		nodes.add(new Node(7,11));
		this.dir = RIGHT;
	}
	
	public boolean contains(int i,int j){
		return nodes.contains(new Node(i,j));
	}
	
	public void step(){
		//去尾巴
		nodes.removeLast();
		//加头
		Node head = nodes.getFirst();
		int i = head.getI() + dir/10;
		int j = head.getJ() + dir%10;
		nodes.addFirst(new Node(i,j));
	}
	
	public void step(int dir){
		if(this.dir + dir == 0){
			throw new RuntimeException("不能往反方向");
		}
		this.dir = dir;
		step();
	}
}
