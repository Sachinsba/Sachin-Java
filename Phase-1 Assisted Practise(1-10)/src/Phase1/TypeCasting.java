package Phase1;

public class TypeCasting {
	public static void main(String[] args) {
		
		System.out.println("Implicit type casting");
		
		byte a = 44;
		System.out.println("Value of a is: "+a);
		
		int b = a;
		System.out.println("Value of b is: "+b);
		short c = a;
		System.out.println("Value of c is: "+c);
		long d = a;
		System.out.println("Value of d is: "+d);
		float e = a;
		System.out.println("Value of e is: "+e);
		double f = a;
		System.out.println("Value of f is: "+f);
		
		System.out.println("\n");
		System.out.println("Explicit type casting");
		
		char ch = 'A';
		System.out.println("Value of ch is: "+ch);
		
		byte g = (byte)ch;
		System.out.println("Value of g is: "+g);
		
		double db = 55.86;
		System.out.println("Value of db is: "+db);
		
		float ft = (float) db;
		System.out.println("Value of ft is: "+ft);
		long lg = (long) db;
		System.out.println("Value of lg is: "+lg);
		byte bt = (byte) db;
		System.out.println("Value of bt is: "+bt);
		short st = (short) db;
		System.out.println("Value of st is: "+st);
		int it = (int) db;
		System.out.println("Value of it is: "+it);
		char cr = (char) db;
		System.out.println("Value of cr is: "+cr);
	}
}
