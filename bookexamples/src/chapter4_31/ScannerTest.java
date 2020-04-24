package chapter4_31;

import java.util.Scanner;

public class ScannerTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Example of an interactive system with the scanner object.
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the amount of bottles there is in this area: ");
		
		// The user writes amount which is transfered into the variable "bottles" due to the nextInt property.
		
		int bottles = in.nextInt();	
		
		System.out.print("There is" + " " + bottles + " " + "in this area.");

	}

}
