package tekstfil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PrintWriterTal {

	public static void main(String[] args) {
		try {
			PrintWriter printWriter = new PrintWriter("tal.txt");
			Scanner scanner = new Scanner(System.in);

			System.out.print("Hvor mange tal skal der skrives til tekstfilen? ");
			int antal = scanner.nextInt();

			Random random = new Random();
			for (int n = 1; n <= antal; n++) {
				int tal = random.nextInt(10000);
				printWriter.println(tal);
			}

			printWriter.close();
			scanner.close();
			System.out.println("Tekstfilen er skrevet!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
