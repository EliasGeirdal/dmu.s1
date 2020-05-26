package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(new File("talfil.txt").getAbsolutePath());
		System.out.println(linFileSearch("src\\opgave4\\talfil.txt", 8965));
		System.out.println(linFileSearch("src\\opgave4\\talfil.txt", 5));
	}

	public static boolean linFileSearch(String fileName, int target) throws FileNotFoundException {
		try (Scanner scan = new Scanner(new File(fileName))) {
			while (scan.hasNextInt()) {
				int k = scan.nextInt();
				if (k == target) {
					return true;
				}
			}
		}
		return false;
	}
}
