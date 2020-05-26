package opgave7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(linFileSearchPerson("src\\opgave7\\personer.txt", "Jensen"));
	}

	public static String linFileSearchPerson(String fileName, String target) throws FileNotFoundException {
		String result = "";
		try (Scanner scan = new Scanner(new File(fileName))) {
			while (scan.hasNextLine()) {
				String[] input = scan.nextLine().split(" ");
				if (input[2].equals(target)) {
					result = input[1] + " " + input[2];
				}
			}
		}
		return result;

	}
}
