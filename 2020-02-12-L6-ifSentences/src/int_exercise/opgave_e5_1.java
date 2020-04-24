package int_exercise;

import java.util.Scanner;

public class opgave_e5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter an integer");

		if (in.hasNextInt()) {
			int number = in.nextInt();

			if (number < 0) {
				System.out.println("The integer is negative");
			}
			if (number == 0) {
				System.out.println("The integer equals 0");
			}
			if (number > 0) {
				System.out.println("The integer is positive");
			}
		} else {
			System.out.println("Error: input is not an integer");
		}
		in.close();

	}

}
