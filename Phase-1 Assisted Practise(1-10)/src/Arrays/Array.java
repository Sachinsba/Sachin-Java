package Arrays;

public class Array{
	public static void main(String [] args)
	{
	//single-dimensional array
	int a[]= {100,200,300,400,500};
	for(int i=0;i<5;i++) {
	System.out.println("Elements of array a: "+a[i]);
	}


	//multidimensional array
	int[][] b = {
	            {21, 44, 61, 844,12}, 
	            {30, 61, 90} };
	      
	      System.out.println("\nLength of row 1: " + b[0].length);
	      }

}