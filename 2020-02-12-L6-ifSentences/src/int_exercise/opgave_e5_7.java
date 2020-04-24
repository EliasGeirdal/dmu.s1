package int_exercise;

import java.util.Scanner;

public class opgave_e5_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter number 1");
		int number1 = in.nextInt();
		System.out.println("Please enter number 2");
		int number2 = in.nextInt();
		System.out.println("Please enter number 3");
		int number3 = in.nextInt();
		

		if (number1 > number2 && number2 > number3) {
			System.out.println("The numbers are decreasing");
		}
		else if(number1 < number2 && number2 < number3) {
			System.out.println("The numbers are increasing");
		}
		else {
			System.out.println("The numbers are neither increasing nor decreasing");
		}
		
		

		
		
		
		in.close();
	}

}
