package java_Core2;

public interface OfficeAble {
	void start();
}

class Word implements OfficeAble{
	@Override
	public void start() {
		System.out.println("word...start...");
		
	}
	
	
}