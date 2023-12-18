package Phase1;

import java.util.Scanner;

public class Methods {
	public int add(int a, int b) {
		int z = a+b;
		return z;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Methods m = new Methods();
		System.out.println("Input two numbers: ");
		int p = scan.nextInt();
		int q = scan.nextInt();
		int res = m.add(p,q);
		System.out.println("Result: "+res);
	}
}
