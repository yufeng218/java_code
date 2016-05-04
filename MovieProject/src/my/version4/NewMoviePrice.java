package my.version4;

public class NewMoviePrice extends Price{
	
	@Override
	public double getPrice(int days) {
		return days*3;
	}
	
	@Override
	public int getFre(int days) {
		if(days>1)
			return 2;
		return 1;
	}
}
