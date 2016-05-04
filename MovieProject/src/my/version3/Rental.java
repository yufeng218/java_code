package my.version3;

public class Rental 
{
	private Movie movie = new Movie(); //×âÁÞÄÄ¸öµçÓ°
	private int days;
	
	public Rental(){}
	public Rental(Movie m,int days) {
		this.movie = m;
		this.days = days;
	}
	public void setMovie(Movie m){
		this.movie = m;
	}
	public Movie getMovie(){
		return this.movie;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	@Override
	public String toString() {
		return movie.getName() + "_" +this.days;
	}
}
