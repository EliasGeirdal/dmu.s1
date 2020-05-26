package tekstfil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Primtal {
	public static void main(String[] args) {
		int[] primtal = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Hvilket nr. primtal skal vises? ");
			int n = scan.nextInt();
			System.out.println("Primtal nr. " + n + " er " + primtal[n - 1] + "\n");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("index out of bounds.");
		} catch (InputMismatchException e) {
			System.out.println("input is not an integer.");
		}
	}
}