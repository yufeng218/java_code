package java_Core4.IO.Properties;


public class FruitTest {

	public static void main(String[] args) {
		
		/*
		Fruit fruit = FruitFactory.getInstance("apple");
		fruit.grow();
		fruit.harvest();
		Fruit fruit1 = FruitFactory.getInstance("grape");
		fruit1.grow();
		fruit1.harvest();
		*/
		
		Fruit fruit = FruitFactory.getClassName();
		fruit.grow();
		fruit.harvest();
		
	}

}
