package my.version3;

public class testMyArray {

	public static void main(String[] args) {
		
		Movie m1 = new Movie("ʿ��ͻ��",2);
		Movie m2 = new Movie("ȫ��Ŀ��",3);
		
		myArrayList list = new myArrayList();
		list.add(m1);
		list.add(m2);
		System.out.println((Movie)list.getIndex(0));
		System.out.println((Movie)list.getIndex(1));
		System.out.println("===========================================");
		
		//���Ա���
		Iterator itor = list.interator();
		while(!itor.isDone()){
			Movie movie = (Movie)itor.getCurrent();
			System.out.println(movie.getName());
			itor.next();
		}
		
		myArrayList list2 = new myArrayList();
		Rental r1 = new Rental(m2,3);
		Rental r2 = new Rental(m1,1);
		list2.add(r1);
		list2.add(r2);
		System.out.println("===========================================");
		Iterator itor2 = list2.interator();
		while(!itor2.isDone()){
			System.out.println((Rental)itor2.getCurrent());
			itor2.next();
		}
	}

}
