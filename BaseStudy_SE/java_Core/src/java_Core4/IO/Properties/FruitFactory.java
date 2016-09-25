package java_Core4.IO.Properties;

import java.io.IOException;
import java.util.Properties;

public class FruitFactory {
	
	public static Fruit getInstance(String name){
		if(name.equalsIgnoreCase("apple"))
			return new Apple();
		if(name.equalsIgnoreCase("grape"))
			return new grape();
		return null;
	}
	
	public static Fruit getClassName(){
		try {
			
			Properties prop = new Properties();
			prop.load(FruitFactory.class.getResourceAsStream("name.properties"));
			String name = prop.getProperty("firstName");
			Fruit fruit = (Fruit)Class.forName(name).newInstance();
//			fruit.grow();
//			fruit.harvest();
			return fruit;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}
