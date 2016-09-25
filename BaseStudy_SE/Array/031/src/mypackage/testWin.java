package mypackage;

public class testWin extends A
{
	public static void main(String[] args)
	{
		testWin bf1 = new testWin();
		testWin bf2 = new testWin();
		if(bf1.equals(bf2))
		{
			System.out.println("xiangdeng");
		}
	}

}

class A
{
	private int num=0;
	public void setNum(int num) {	this.num = num;	}
	public int getNum(){	return this.num;	}
	
	public boolean equals(A obj) {
		return (this.num == obj.num);
	    }

}


