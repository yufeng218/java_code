package java_Core3;

public class WormPanel {
	private Worm worm = new Worm();
	
	public Worm getWorm() {
		return worm;
	}

	public void setWorm(Worm worm) {
		this.worm = worm;
	}

	public void print(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 32; j++){
				if(i == 0 || i == 9){
					System.out.print("-");
				} else if(j == 0 || j==31){
					System.out.print("|");
				} else if(worm.contains(i, j)){
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
}
