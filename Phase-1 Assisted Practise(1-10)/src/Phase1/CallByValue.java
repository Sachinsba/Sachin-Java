package Phase1;

import java.util.Scanner;

public class CallByValue {
	
	int mult(int num) {
		int res = num*num;
		return res;
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CallByValue c = new CallByValue();
		c.mult(15);
		System.out.println("After multiplication: "+c.mult(15));
	}
}
