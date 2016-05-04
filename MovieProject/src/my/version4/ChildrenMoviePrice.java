package my.version4;

public class ChildrenMoviePrice extends Price{
	
	@Override
	public double getPrice(int days) {
		if(days<=2)
			return 2;
		return (days-2)*1.5 + 2;
	}
}
