package java_Core3;

public class LinkedListDemo2 {
	public static void main(String[] args) {
		Node1 node1 = new Node1("10");
		node1.next = new Node1("J");
		node1.next.next = new Node1("Q");
		node1.next.next.next = new Node1("K");
	}
}



class Node1{
	Object value;
	Node1 next;
	public Node1(Object value){
		this.value = value;
	}
	@Override
	public String toString() {
		return next == null ? value.toString() : (value + "," + "next");
	}
	
	
}
