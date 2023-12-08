import java.util.Scanner;

public class ArithmeticCalculator {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Reading operator from user
		System.out.print("Choose operator: ");
		char operator = scan.next().charAt(0);
		
		
		//taking two numbers to perform arithmetic operation
		System.out.print("Enter first number: ");
		double num1 = scan.nextDouble();
		System.out.print("Enter second number: ");
		double num2 = scan.nextDouble();
		
		switch(operator) {
		//performs addition of two numbers
		case '+':
			double add = num1+num2;
			System.out.println("The Addition of two numbers is: "+add);
			break;
			
		//performs subtraction of two numbers
		case '-':
			double sub = num1-num2;
			System.out.println("The subtraction of two numbers is: "+sub);
			break;
			
		//performs multiplication of two numbers
		case '*':
			double mult = num1*num2;
			System.out.println("The multiplication of two numbers is: "+mult);
			break;
			
		//performs division of two numbers
		case '/':
			if(num2 != 0) {
				double div = num1/num2;
				System.out.println("The division of two numbers is: "+div);
				break;
			}
			else {
				System.out.println("The division is not possible");
			}
			break;
			
		default:System.out.println("You have not entered any operator");
		}
	}
}
