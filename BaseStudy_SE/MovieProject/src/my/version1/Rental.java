package my.version1;

public class Rental 
{
	private Movie movie = new Movie(); //�����ĸ���Ӱ
	private int days;
	
	public Rental(){}
	public Rental(int days) {
		this.days = days;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Movie getMovie() {
		return movie;
	}
}
