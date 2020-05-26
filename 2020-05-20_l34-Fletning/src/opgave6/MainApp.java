package opgave6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MainApp.findfællesTal("src\\opgave6\\fileName1", "src\\opgave6\\fileName2", "src\\opgave6\\talfilNy.txt");
	}

	public static void findfællesTal(String fileName1, String fileName2, String fileNameNy)
			throws FileNotFoundException {
		// Create a scanner for each document.
		Scanner scan1 = new Scanner(new File(fileName1));
		Scanner scan2 = new Scanner(new File(fileName2));
		// Create new file.
		File file = new File(fileNameNy);
		PrintWriter pw = new PrintWriter(file);
		// Assign scanners next integer values into local variables.
		int i1 = scan1.nextInt();
		int i2 = scan2.nextInt();

		// Checks if they are duplicates.
		while (scan1.hasNextInt() && scan2.hasNextInt()) {
			if (i1 < i2) { // if one comes before another, go next.
				i1 = scan1.nextInt();
			} else if (i1 > i2) {
				i2 = scan2.nextInt();
			} else { // if they are duplicates, print in new file.
				pw.println(i1);
				i1 = scan1.nextInt();
				i2 = scan2.nextInt();
			}
		}
		scan1.close();
		scan2.close();
		pw.close();
	}

}
