package opgave_e5_1;

import java.util.Scanner;

public class Pair {

	// Instance variables

	// method

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Please enter a pair");

		if (in.hasNextInt()) {
			int p1 = in.nextInt();
			System.out.print(p1);

		} else
			System.out.println("Input is not an integer");
	}
}
