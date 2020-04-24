package programmingprojects_chapter6;

import java.util.Scanner;

public class PrimeApp {

	public static void main(String[] args) {
		PrimeGenerator p = new PrimeGenerator();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = in.nextInt();
		p.primTal(number);

		in.close();

	}

}
