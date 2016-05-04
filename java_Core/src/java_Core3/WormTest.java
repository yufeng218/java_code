package java_Core3;

import java.util.Scanner;

public class WormTest {
	
	public static void main(String[] args) {
		/*
		Node node1 = new Node(1,1);
		Node node2 = new Node(1,1);
		System.out.println(node1.equals(node2));*/
		
		WormPanel panel = new WormPanel();
		Worm worm = panel.getWorm();
		/*
		for(int i =0; i < 10; i++){
			panel.print();
			worm.step();
			try {
				Thread.sleep(1000); //ÑÓÊ±1Ãë
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		*/
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			String dir = scanner.nextLine();
			if(dir.equalsIgnoreCase("u")){
				worm.step(worm.UP);
			} else if(dir.equalsIgnoreCase("d")){
				worm.step(worm.DOWN);
			} else if(dir.equalsIgnoreCase("l")){
				worm.step(worm.LEFT);
			} else if(dir.equalsIgnoreCase("r")){
				worm.step(worm.RIGHT);
			} else if(dir.equalsIgnoreCase("bye")){
				System.out.println("^-^");
				System.exit(0);
			} else {
				worm.step();
			}
			panel.print();
			
		}
	}
}
