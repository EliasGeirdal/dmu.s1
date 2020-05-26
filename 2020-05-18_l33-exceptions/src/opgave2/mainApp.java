package opgave2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = new PrintWriter("tal.txt");
		Scanner in = new Scanner("2.txt");
		int length = 0;
		if (in.hasNextInt()) {
			length = in.nextInt();
		}
		int[] size = new int[length];
		for (int i = 0; i < size.length; i++) {
			if (in.hasNextInt()) {
				size[i] = in.nextInt() * 2;
			} else
				throw new IllegalArgumentException("invalid arguments in 2.txt. Must contain integers.");
		}
	}

}
