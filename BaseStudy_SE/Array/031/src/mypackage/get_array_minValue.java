package mypackage;

public class get_array_minValue {
	
	private static void printArray(int arr[][])
	{
		//��ӡ���������
		for(int x[]:arr)
		{
			for(int i=0;i<x.length;i++)
			 {
				 System.out.print(x[i]+" ");
			 }
			System.out.println();
		}
		
	}
	
	private static void changeArray(int arr[][])
	{
		int newArray[][] = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length;j++)
			{
				newArray[i][j] = arr[j][i];
			}
		printArray(newArray);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int arr[][] = new int[][]{{1,2,3},{6,7,8},{10,11,12}};
		System.out.println("���е���ǰ������:");
		printArray(arr);
		System.out.println("���е����������:");
		changeArray(arr);
	}
}
