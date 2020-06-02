package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub

//		MainApp.fletAlleHeltal("C:\\Users\\elgei\\eclipse-workspace\\2020-05-20_l34-Fletning\\src\\opgave5\\talfil1",
//				"C:\\Users\\elgei\\eclipse-workspace\\2020-05-20_l34-Fletning\\src\\opgave5\\talfil2",
//				"C:\\Users\\elgei\\eclipse-workspace\\2020-05-20_l34-Fletning\\src\\opgave5\\talfilNy.txt");
		MainApp.fletAlleHeltal("src\\opgave5\\talfil1", "src\\opgave5\\talfil2", "src\\opgave5\\talfilNy.txt");

	}

	/**
	 * Laver en sorteret fil i fileNameNy der indeholder alle heltal fra fileName1
	 * og fileName2 (MAX_VALUE skal ikke i resultatet) Krav: filename1 og filename2
	 * er navne på to sorterede filer.
	 * 
	 * @param fileName1
	 * @param fileName2
	 * @param fileNameNy
	 * @throws FileNotFoundException
	 */
	public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy)
			throws FileNotFoundException, IOException {
		// create a scanner for each document.
		Scanner scan1 = new Scanner(new File(fileName1));
		Scanner scan2 = new Scanner(new File(fileName2));
		// create a new file
		File file = new File(fileNameNy);
		PrintWriter pw = new PrintWriter(file);
		// assign integer values from scanner into local variables.
		int i1 = scan1.nextInt();
		int i2 = scan2.nextInt();
		// while both documents has more integers.
		while (scan1.hasNextInt() && scan2.hasNextInt()) {
			// check which is lexicographically lowest.
			if (i1 < i2) {
				pw.println(i1);
				i1 = scan1.nextInt();
			} else if (i2 < i1) {
				pw.println(i2);
				i2 = scan2.nextInt();
			} else { // if they are the same, print i1 first.
				pw.println(i1);
				i1 = scan1.nextInt();
			}
		}
		// empty rest of files.
		while (scan1.hasNextInt()) {
			pw.println(i1);
			i1 = scan1.nextInt();
		}
		while (scan2.hasNextInt()) {
			pw.println(i2);
			i2 = scan2.nextInt();
		}
		// print last elements.
//		if (i1 < i2) {
//			pw.println(i1);
//			pw.println(i2);
//		} else {
//			pw.println(i2);
//			pw.println(i1);
//		}

		scan1.close();
		scan2.close();
		pw.close();
	}
}
